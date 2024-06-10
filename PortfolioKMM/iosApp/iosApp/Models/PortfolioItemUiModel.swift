//
//  PortfolioItemUiModel.swift
//  iosApp
//
//  Created by tina on 2024-06-10.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

struct PortfolioItemUiModel: Identifiable {
    public var id: String {
        return slug
    }

    public let title: String
    public let slug: String
    public let featuredImage: String
    public let excerpt: String
}
