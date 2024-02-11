/**
 * Visual testing for the navigation section.
 * - Visits the specified page.
 * - Captures a screenshot of the navigation section.
 * - Compares the captured screenshot with the provided snapshot.
 */
describe("Navigation Section", () => {
  /**
   * Test case to compare a screenshot of the navigation section.
   */
  it("should compare screenshot of the navigation section", () => {
    // Visit the specified page
    cy.visit(Cypress.env("HOME_PAGE_URL"));

    cy.viewport(1079, 726);

    cy.then(() => {
      // Ensure the navigation-section element is visible in the viewport
      cy.get(".navigation-section-desktop").should("be.visible");

      // Capture screenshot of the navigation section
      cy.get(".navigation-section-desktop").compareSnapshot(
        "provided-navigation",
        Cypress.env("TEST_THRESHOLD")
      );
    });
  });

  /**
   * Test case to compare a screenshot of the navigation section in the mobile view.
   */
  it("should compare screenshot of the navigation section in the mobile view", () => {
    // Visit the specified page
    cy.visit(Cypress.env("HOME_PAGE_URL"));

    // Go with the size - Laptop (1079 x 726)
    cy.viewport(414, 896);

    // Ensure the profile icon element is visible in the viewport
    cy.get(".profile-icon-button").should("be.visible");

    // Click the 'profile-icon'
    cy.get(".profile-icon-button").click();

    // Ensure the navigation-section element is visible in the viewport
    cy.get(".navigation-section-mobile").should("be.visible");

    // Capture screenshot of the navigation section
    cy.get(".navigation-section-mobile").compareSnapshot(
      "MV-provided-navigation",
      Cypress.env("TEST_THRESHOLD")
    );
  });
});
