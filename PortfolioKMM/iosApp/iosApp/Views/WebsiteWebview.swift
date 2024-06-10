//
//  WebsiteWebView.swift
//  iosApp
//
//  Created by tina on 2024-06-10.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct WebsiteWebView: View {

    var urlString: String
    var url: URL

    init(url: String) {
        self.urlString = url
        self.url = URL(string: url)!
    }

    var body: some View {
        CustomWebView(url: self.url)
    }
}
