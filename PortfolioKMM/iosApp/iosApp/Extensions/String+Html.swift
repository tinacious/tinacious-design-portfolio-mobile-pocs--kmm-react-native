import Foundation

extension String {
    func replace(target: String, withString: String) -> String {
        return self.replacingOccurrences(of: target, with: withString)
    }
}

extension String {
    func replaceHtmlEntities() -> String {
        return self.replacingOccurrences(of: "&quot;", with: "\"")
    }
}
