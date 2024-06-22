import * as React from 'react';
import Svg, { G, Defs, Circle, Rect, ClipPath } from 'react-native-svg';

export default function TinaciousDesignLogo({
  size = 512,
}: {
  size: number;
}) {
  return (
    <Svg width={size} height={size} viewBox="0 0 512 512" fill="none">
      <G clipPath="url(#clip0_102_38)">
        <Circle cx="256" cy="256" r="250" fill="#1D1D26" stroke="#EC028C" strokeWidth="12" />
        <Rect x="160" y="136" width="240" height="24" rx="12" fill="#EC028C" />
        <Rect x="100" y="190" width="240" height="24" rx="12" fill="#00BFFF" />
        <Rect x="160" y="244" width="240" height="24" rx="12" fill="#FFCC66" />
        <Rect x="100" y="298" width="240" height="24" rx="12" fill="#00CED1" />
        <Rect x="160" y="352" width="240" height="24" rx="12" fill="#CC66FF" />
      </G>
      <Defs>
        <ClipPath id="clip0_102_38">
          <Rect width="512" height="512" fill="white" />
        </ClipPath>
      </Defs>
    </Svg>
  );
}
