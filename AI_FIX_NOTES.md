# AI Fix Notes

Session: seq-1776671253819-dquo1pije
Repository: Ncorp29/AutomationExcercise

- [1] (critical) src/test/java/utilities/FileUploadUtilities.java: Uses Runtime.getRuntime().exec(autoItScriptPath) with an unvalidated external path. This can execute arbitrary commands if the input is tampered with, creating a command-injection / arbitrary code execution risk. Restrict execution to a fixed allowlist, validate the path, and avoid shell execution where possible.
- [2] (high) src/test/java/pageObject/AddReviewPage.java: The page object uses multiple highly specific and fragile XPath expressions, including long absolute paths. This is an anti-pattern in Selenium tests and significantly increases maintenance cost. Replace with stable locators such as IDs, names, CSS classes, or data-testid attributes when possible.
- [3] (high) src/test/java/pageObject/CategoryProductsPage.java: Locators rely on nested XPath and text-driven expansion of categories/subcategories. This is fragile and likely to break when UI copy or structure changes. Consider more stable locators and helper methods for category navigation.
- [4] (high) src/test/java/pageObject/ContactUs.java: Page Object appears incomplete and contains unused/unfinished code comments (e.g., commented-out file input logic, imports like Actions/By that may be unused). This indicates poor cohesion and likely a broken abstraction. Verify the class compiles and remove dead code.
- [5] (high) src/test/java/pageObject/ContactUs.java: Contains file upload functionality. If the implementation accepts arbitrary file paths without validation, it may expose local file upload risks or test environment leakage. Restrict uploads to known-safe test fixtures and validate input paths.

# AI Fix Notes

Session: seq-1772012062994-k5tqc7sbj
Repository: Ncorp29/AutomationExcercise

- [1] (high) src/test/java/pageObject/ProductDetailsPage.java: The field `ViewProduct` is initialized with `driver.findElement(...)` at declaration time. This forces Selenium to locate the element immediately when the page object is constructed, which often happens before the page is ready and bypasses lazy evaluation provided by `@FindBy` + `PageFactory`. This leads to frequent `NoSuchElementException`s. Convert this to a `@FindBy` field or locate the element inside a method once the page is loaded.
- [2] (high) src/test/java/pageObject/SearchProductPage.java: Both AllProducts and SearchItem reference the same `h2[@class='title text-center']` locator. This makes it impossible to distinguish between the “all products” heading and the search result heading, so assertions relying on one or the other will always succeed (or always fail) and mask functional regressions. Use more specific locators or introduce descriptive container contexts so each element reflects the intended UI region.
- [3] (high) src/test/java/testCases/TC_0015_SignupMultipleUsers.java: The data-driven signup test blindly creates new user accounts on every run and never cleans up or guards against duplicate emails. This floods the application under test with redundant records, burns through backend resources, and will start failing once the signup endpoint rejects previously used data or throttles requests. Introduce a teardown/cleanup strategy, reuse existing accounts when possible, or add logic to verify if the test data already exists before creating another record.
- [4] (high) src/test/java/testCases/TC_003_Acc_Info.java: The test performs signup flow but never asserts the application state after the flow completes. Without assertions (e.g. verify account creation success message), failures in the flow will not fail the test, causing false positives. Add explicit verifications on key outcomes before ending the test.
- [5] (high) src/test/java/testCases/TC_008_ProductQun.java: Test method implementation ends with an ellipsis (`...`), which results in invalid Java syntax and prevents the suite from compiling/executing. Complete the method body or remove the placeholder before running tests.

