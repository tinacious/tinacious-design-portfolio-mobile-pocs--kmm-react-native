import { ScrollView, StyleSheet } from 'react-native';
import { View } from '@/components/Themed';
import { useApi } from '@/providers/ApiProvider';
import { useCallback, useEffect, useState } from 'react';
import { PortfolioItem } from '@/app/lib/PortfolioItem';
import { PortfolioItems } from '@/components/PortfolioItems';
import { useNavigation } from '@react-navigation/native';

export default function PortfolioScreen() {
  const [portfolioItems, setPortfolioItems] = useState<PortfolioItem[]>([])
  const apiClient = useApi()

  const navigation = useNavigation()

  useEffect(() => {
    apiClient
      .getPortfolioItems()
      .then(data => {
        setPortfolioItems(data)
      })
  }, []);

  const onNavigateToPortfolioItem = useCallback((slug: string) => {
    const url = `https://tinaciousdesign.com/portfolio/${slug}?minimal=1`
    navigation.navigate('webview', { url })
  }, [])

  return (
      <ScrollView>
        <View style={styles.container}>
          {/*<View style={styles.separator} lightColor="#eee" darkColor="rgba(255,255,255,0.1)" />*/}

          <PortfolioItems
            items={portfolioItems}
            onNavigateToPortfolioItem={onNavigateToPortfolioItem}
          />

          {/*<EditScreenInfo path="app/(tabs)/index.tsx" />*/}
        </View>
      </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  title: {
    fontSize: 20,
    fontWeight: 'bold',
  },
  separator: {
    marginVertical: 30,
    height: 1,
    width: '80%',
  },
});
