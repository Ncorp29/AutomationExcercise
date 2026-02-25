# AI Fix Notes

Session: seq-1772001668734-vqkm8j58t
Repository: Ncorp29/AutomationExcercise

- [1] (critical) src/test/java/pageObject/ProductDetailsPage.java: The page object constructor never calls PageFactory.initElements(driver, this) (nor does BasePage as per the code shown). As a result, every @FindBy WebElement remains null and any interaction (e.g., click/view methods) immediately throws NullPointerException. Initialize the page factory in the constructor or BasePage to hydrate the locators.
- [2] (high) src/test/java/pageObject/ProductDetailsPage.java: The field ViewProduct is initialized using driver.findElement(...) at declaration time, which runs before the page is navigated to and before the constructor completes. This is fragile and will throw NoSuchElementException if the target element is not yet present. Refactor to lazy-load within a method or use @FindBy with a proper wait.
- [3] (high) src/test/java/utilities/FileUploadUtilities.java: Runtime.getRuntime().exec(autoItScriptPath) executes an external script using an unvalidated path, which exposes the automation suite to command-injection risks if the script location is influenced by configuration or input. Validate against a whitelist, avoid shell execution by using ProcessBuilder with clearly separated arguments, and ensure only trusted scripts are invoked.
- [4] (medium) src/test/java/pageObject/AddReviewPage.java: Locators such as the very long absolute XPath used for ViewProd are brittle and break easily when the DOM hierarchy changes. Prefer shorter, semantic locators (e.g., data-testid attributes or relative XPath based on stable parents) or CSS selectors.
- [5] (medium) src/test/java/pageObject/HomePage.java: The Cart locator uses an absolute Xpath that traverses the entire DOM tree. This selector is highly brittle and will break on any structural change to the header. Prefer context-aware, resilient locators (e.g. `By.linkText`, CSS selectors scoped to stable wrappers, or data attributes).

