import React, { FC, useMemo } from 'react';
import { Dimensions, Image, Pressable, StyleSheet } from 'react-native';
import { PortfolioItem } from '@/app/lib/PortfolioItem';
import Colors from '@/constants/Colors';
import { Text, View } from './Themed';

type PortfolioItemsProps = {
  onNavigateToPortfolioItem: (slug: string) => void
  items: PortfolioItem[]
};

export const PortfolioItems: FC<PortfolioItemsProps> = ({
  onNavigateToPortfolioItem,
  items,
}) => {
  const { width } = Dimensions.get('window')

  const cardImageHeight = useMemo(() => {
    return width / 1.780821917808219
  }, [width])

  return (
    <View style={styles.container}>
      {items.map((item) => (
        <Pressable key={item.slug} onPress={() => onNavigateToPortfolioItem(item.slug)}>
          <View>
            <Image
              style={{ width, height: cardImageHeight }}
              src={item.featuredImage.url}
              alt={item.featuredImage.altText}
            />

            <View style={styles.textWrapper}>
              <Text style={styles.title} lightColor={Colors.light.text} darkColor={Colors.dark.text}>
                {item.title}
              </Text>

              <Text style={styles.excerpt}>
                {item.excerptHtml.replaceAll('&quot;', '"')}
              </Text>
            </View>
          </View>
        </Pressable>
      ))}
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  textWrapper: {
    padding: 12,
  },
  title: {
    fontSize: 20,
    fontWeight: 'bold',
  },
  excerpt: {
    fontSize: 17,
    marginTop: 10,
    marginBottom: 24,
    lineHeight: 17 * 1.4,
  },
});
