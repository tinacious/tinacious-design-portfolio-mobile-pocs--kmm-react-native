import Foundation

extension String {
    func replaceHtmlEntities() -> String {
        return self.replacingOccurrences(of: "&quot;", with: "\"")
    }
}
