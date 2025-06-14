const { expect } = require("../../main/frontend/node_modules/@playwright/test");
const {
  createBdd,
} = require("../../main/frontend/node_modules/playwright-bdd");

const { test } = require("../src/fixtures");
const { Given, When, Then } = createBdd(test);

Given("el usuario accede a la aplicación", async ({ page }) => {
  await page.goto("/");
});

Then("se muestra el mensaje de bienvenida", async ({ page }) => {
  let dialog = page.locator('p-dialog:has-text("Repartir")');
  await dialog.waitFor({ state: "hidden", timeout: 2000 });
});

When("decidió iniciar", async ({ page }) => {
  await page.getByRole("textbox").fill("julian");
  await page.locator("#iniciarBienvenidaButton").click();
});

Then("puede empezar a usarla", async ({ page }) => {
  await page.locator("#crearGruposButton").click();
  let nuevoGrupoDialog = page.locator("#nuevoGrupoDialog");

  await expect(nuevoGrupoDialog).toContainText("Nuevo Grupo");
});
