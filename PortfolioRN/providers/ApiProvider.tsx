import { createContext, FC, ReactNode, useCallback, useContext, useEffect, useMemo, useState } from 'react';
import Axios, { AxiosInstance } from 'axios'
import { PortfolioItem } from '@/app/lib/PortfolioItem';

// import { Environment } from '../utils/Environment';

interface ApiClient {
  makeGet<T extends Record<string, unknown>>(url: string): Promise<T>
  getPortfolioItems(): Promise<PortfolioItem[]>
}

const ApiClientContext = createContext<ApiClient>({
  makeGet: () => Promise.reject(),
  getPortfolioItems: (): Promise<PortfolioItem[]> => Promise.reject(),
})

type ApiProviderProps = {
  children: ReactNode
}

export const ApiProvider: FC<ApiProviderProps> = ({
  children,
}) => {
  const axiosInstance: AxiosInstance = useMemo((): AxiosInstance => {
    const instance = Axios.create({
      baseURL: 'https://tinaciousdesign.com/api/',
      headers: {
        'X-Client': 'tinacious-design-rn',
        'X-Client-Version': '0.0.1',
      }
    })

    // Add HTTP interceptors

    return instance
  }, [])

  const makeGet = useCallback(
    async <T extends Record<string, unknown>>(url: string): Promise<T> => {
      const res = await axiosInstance.get<T>(url)
      return res.data
    },
    [axiosInstance]
  )

  const getPortfolioItems = useCallback(async () => {
    const res = await axiosInstance.get<{ data: PortfolioItem[] }>('portfolio')
    return res.data.data
  }, [axiosInstance])

  return (
    <ApiClientContext.Provider
      value={{
        makeGet,
        getPortfolioItems,
      }}>
      {children}
    </ApiClientContext.Provider>
  )
}

export const useApi = (): ApiClient => useContext(ApiClientContext)

// export const useApi = (): ApiClient | null => {
//   const [isMounted, setIsMounted] = useState(false)
//
//   useEffect(() => {
//     setIsMounted(true)
//   }, [])
//
//   const context = useContext(ApiClientContext)
//
//   return isMounted ? context : null
// }
