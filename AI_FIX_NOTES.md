# AI Fix Notes

Session: seq-1777007559418-hqb08apun
Repository: Ncorp29/AutomationExcercise

- [1] (critical) src/test/java/utilities/FileUploadUtilities.java: Uses Runtime.getRuntime().exec(autoItScriptPath) on an externally supplied path. This can execute arbitrary binaries/scripts if the input is influenced by untrusted data. Validate and whitelist allowed executables, or replace with a safer upload mechanism.
- [2] (high) src/test/java/pageObject/Acc_InfoPage.java: The page object uses non-idiomatic naming for fields (e.g., Title, Password, dayDropdown) and likely relies on direct WebElement handling. Follow Java conventions (camelCase, private fields) and ensure a consistent PageFactory initialization pattern.
- [3] (high) src/test/java/pageObject/BasePage.java: BasePage stores WebDriver in a package-private field and provides no helper methods for waits, safe clicks, or common synchronization. This encourages duplicated logic across page objects and increases flakiness in UI tests.
- [4] (high) src/test/java/pageObject/ContactUs.java: Page Object fields are package-private and constructor contains TODO/stub behavior. In Selenium page objects, fields should be private and initialized consistently via PageFactory to avoid fragile tests and hidden coupling.
- [5] (high) src/test/java/pageObject/HomePage.java: The Cart locator uses an absolute XPath (/html[1]/body[1]/...), which is brittle and likely to break with minor DOM changes. Prefer stable attributes, relative XPath, CSS selectors, or data-testid-style locators.

# AI Fix Notes

Session: seq-1776671394467-xqkcodpmo
Repository: Ncorp29/AutomationExcercise

- [1] (critical) src/test/java/utilities/ExcelUtility.java: Excel file handling uses mutable public fields (FileInputStream, FileOutputStream, workbook, sheet, row, cell) and likely manual stream management. This is unsafe and error-prone, increasing the risk of resource leaks and inconsistent state. Encapsulate fields, use try-with-resources, and close streams in finally blocks or auto-closeable patterns.
- [2] (high) src/test/java/pageObject/Acc_InfoPage.java: Page Object fields appear to be package-private rather than private, which weakens encapsulation and makes the class harder to maintain safely. Selenium page objects should keep locators private and expose intent-based methods.
- [3] (high) src/test/java/pageObject/AddReviewPage.java: The page object appears to rely on long absolute/ordinal XPaths for navigation and review submission. Such locators are fragile and can break when the DOM layout changes. Replace with resilient locators anchored to stable elements or semantic attributes.
- [4] (high) src/test/java/pageObject/BasePage.java: Based on the pattern in descendant page objects, the framework likely centralizes WebDriver actions without visible secure handling of credentials, test data, or environment isolation. Ensure secrets are never hardcoded, and use environment variables or secure vaults for credentials.
- [5] (high) src/test/java/pageObject/CategoryProductsPage.java: Locators are strongly coupled to visible text and nested DOM structure (e.g., category/subcategory XPaths). This introduces high brittleness and risks frequent false failures when UI copy or layout changes.

# AI Fix Notes

Session: seq-1772012062994-k5tqc7sbj
Repository: Ncorp29/AutomationExcercise

- [1] (high) src/test/java/pageObject/ProductDetailsPage.java: The field `ViewProduct` is initialized with `driver.findElement(...)` at declaration time. This forces Selenium to locate the element immediately when the page object is constructed, which often happens before the page is ready and bypasses lazy evaluation provided by `@FindBy` + `PageFactory`. This leads to frequent `NoSuchElementException`s. Convert this to a `@FindBy` field or locate the element inside a method once the page is loaded.
- [2] (high) src/test/java/pageObject/SearchProductPage.java: Both AllProducts and SearchItem reference the same `h2[@class='title text-center']` locator. This makes it impossible to distinguish between the “all products” heading and the search result heading, so assertions relying on one or the other will always succeed (or always fail) and mask functional regressions. Use more specific locators or introduce descriptive container contexts so each element reflects the intended UI region.
- [3] (high) src/test/java/testCases/TC_0015_SignupMultipleUsers.java: The data-driven signup test blindly creates new user accounts on every run and never cleans up or guards against duplicate emails. This floods the application under test with redundant records, burns through backend resources, and will start failing once the signup endpoint rejects previously used data or throttles requests. Introduce a teardown/cleanup strategy, reuse existing accounts when possible, or add logic to verify if the test data already exists before creating another record.
- [4] (high) src/test/java/testCases/TC_003_Acc_Info.java: The test performs signup flow but never asserts the application state after the flow completes. Without assertions (e.g. verify account creation success message), failures in the flow will not fail the test, causing false positives. Add explicit verifications on key outcomes before ending the test.
- [5] (high) src/test/java/testCases/TC_008_ProductQun.java: Test method implementation ends with an ellipsis (`...`), which results in invalid Java syntax and prevents the suite from compiling/executing. Complete the method body or remove the placeholder before running tests.

