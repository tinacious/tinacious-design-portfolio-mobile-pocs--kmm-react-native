import React from 'react';
import FontAwesome from '@expo/vector-icons/FontAwesome';
import { Tabs } from 'expo-router';
import { Linking } from 'react-native';

import Colors from '@/constants/Colors';
import { useColorScheme } from '@/components/useColorScheme';
import { useClientOnlyValue } from '@/components/useClientOnlyValue';
import TinaciousDesignLogo from '@/components/icons/TinaciousDesignLogo';

// You can explore the built-in icon families and icons on the web at https://icons.expo.fyi/ (only FontAwesome supported)
function TabBarIcon(props: {
  name: React.ComponentProps<typeof FontAwesome>['name'];
  color: string;
}) {
  return <FontAwesome size={28} style={{ marginBottom: -3 }} {...props} />;
}

export default function TabLayout() {
  const colorScheme = useColorScheme();

  return (
    <Tabs
      screenOptions={{
        tabBarActiveTintColor: Colors[colorScheme ?? 'light'].tint,
        // Disable the static render of the header on web
        // to prevent a hydration error in React Navigation v6.
        headerShown: useClientOnlyValue(false, true),
      }}>

      <Tabs.Screen
        name="index"
        options={{
          title: 'Portfolio',
          tabBarIcon: ({ color }) => <TabBarIcon name="star-o" color={color} />,
        }}
      />

      <Tabs.Screen
        name="code"
        options={{
          title: 'Code',
          tabBarIcon: ({ color }) => <TabBarIcon name="code" color={color} />,
        }}
        listeners={({navigation}) => ({
          tabPress: event => {
            event.preventDefault();
            Linking.openURL('https://github.com/tinacious/tinacious-design-portfolio-mobile-pocs/tree/main/PortfolioRN')
          },
        })}
      />

      <Tabs.Screen
        name="about"
        options={{
          title: 'About',
          tabBarIcon: ({ color }) => <TinaciousDesignLogo size={25} />,
        }}
        listeners={({navigation}) => ({
          tabPress: event => {
            event.preventDefault();
            Linking.openURL('https://tinaciousdesign.com')
          },
        })}
      />

      {/*<Tabs.Screen*/}
      {/*  name="sample"*/}
      {/*  options={{*/}
      {/*    title: 'Sample',*/}
      {/*    tabBarIcon: ({ color }) => <TabBarIcon name="code" color={color} />,*/}
      {/*    headerRight: () => (*/}
      {/*      <Link href="/modal" asChild>*/}
      {/*        <Pressable>*/}
      {/*          {({ pressed }) => (*/}
      {/*            <FontAwesome*/}
      {/*              name="info-circle"*/}
      {/*              size={25}*/}
      {/*              color={Colors[colorScheme ?? 'light'].text}*/}
      {/*              style={{ marginRight: 15, opacity: pressed ? 0.5 : 1 }}*/}
      {/*            />*/}
      {/*          )}*/}
      {/*        </Pressable>*/}
      {/*      </Link>*/}
      {/*    ),*/}
      {/*  }}*/}
      {/*/>*/}
    </Tabs>
  );
}
