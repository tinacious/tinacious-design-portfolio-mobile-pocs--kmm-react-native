import { Category } from '@/app/lib/Category';
import { Image } from '@/app/lib/Image';

export type PortfolioItem = {
  title: string
  slug: string
  launchDate: string
  showLaunchDate: bool
  isFeatured: bool
  contentHtml: string
  excerptHtml: string
  website: string
  categories: Category[]
  images: Image[]
  featuredImage: Image
}
