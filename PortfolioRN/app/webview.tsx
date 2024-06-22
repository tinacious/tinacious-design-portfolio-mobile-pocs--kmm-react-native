import React, { FC } from 'react';
import { Appearance, StyleSheet } from 'react-native';
import { useRoute } from '@react-navigation/core';
import WebView from 'react-native-webview';
import { SafeAreaView } from 'react-native-safe-area-context';
import { ViewProps } from '@/components/Themed';

type WebViewScreenProps = ViewProps & {};

// NOTE: This plugin is busted on Android and doesn't detect dark mode:
//    https://github.com/react-native-webview/react-native-webview/issues/2866
//    https://github.com/react-native-webview/react-native-webview/issues/3253

const WebViewScreen: FC<WebViewScreenProps> = ({
}) => {
  const route = useRoute()
  const url = (route.params as { url?: string })?.url

  // const colorScheme = Appearance.getColorScheme()
  // const timestamp = (new Date()).getTime()

  if (!url) return null

  return (
    <SafeAreaView style={styles.container}>
      <WebView
        // key={`webview-${timestamp}-${colorScheme}`}
        // forceDarkOn={colorScheme == 'dark'} // This doesn't actually work on Android and isn't necessary on iOS
        style={styles.webview}
        source={{ uri: url }}
      />
    </SafeAreaView>
  )
}

export default WebViewScreen

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  webview: {
    flex: 1,
  },
});

