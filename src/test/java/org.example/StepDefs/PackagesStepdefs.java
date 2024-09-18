package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Base;
import org.example.pages.EventActions;
import org.example.pages.PackagesActions;
import org.testng.Assert;

public class PackagesStepdefs {
    PackagesActions packagesActions;
    EventActions eventActions;
    public PackagesStepdefs(){
        packagesActions = new PackagesActions();
        eventActions = new EventActions();
    }
    @And("I open {string} code Event")
    public void iOpenCodeEvent(String eventCode){
    Assert.assertTrue(eventActions.openEventCode(eventCode));
    }


    @And("I click on planning option")
    public void iClickOnPlanningOption() {
        packagesActions.clickOnPlanningOption();
    }

    @And("I choose Packages option")
    public void iChoosePackagesOption() {
        Assert.assertTrue(packagesActions.clickOnPackagesOption());
    }

    @And("I click on add a new package button")
    public void iClickOnAddANewPackageButton() {
        Assert.assertTrue(packagesActions.clickOnAddAnewPackagebtn());
    }

    @When("I enter {string} in the package title")
    public void iEnterInThePackageTitle(String pkgTitle) {
        packagesActions.enterPackageTitle(pkgTitle);
    }

    @And("I enter {string} in the priority")
    public void iEnterInThePriority(String priority) {
        packagesActions.enterThePriority(priority);
    }

    @And("I choose the {string} in Feature Icon")
    public void iChooseTheInFeatureIcon(String iconNumber) {
        packagesActions.chooseTheIcon(iconNumber);
    }

    @And("I enter {string} in the Feature name")
    public void iEnterInTheFeatureName(String featureName) {
        packagesActions.enterFeatureName(featureName);
    }

    @And("I choose {string} in the Type menu")
    public void iChooseInTheTypeMenu(String typeOption) {
        packagesActions.chooseFeatureType(typeOption);
    }

    @And("I click on Save package")
    public void iClickOnSavePackage() {
        packagesActions.clickOnSavePackage();
    }

    @Then("The new {string} package is generated")
    @Then ("The {string} package is updated")
    public void theNewPackageIsGenerated(String pkgName) {
        Assert.assertTrue(packagesActions.checkThePackageGeneration(pkgName));
        Base.tearDown();
    }

    @And("I click on edit {string} package")
    public void iClickOnEditPackage(String pkgName) {
        Assert.assertTrue(packagesActions.clickOnEditPkg(pkgName));

    }


    @And("I click on Update button")
    public void iClickOnUpdateButton() {
        packagesActions.clickOnUpdateBtn();
    }

    @When("I click on delete package button")
    public void iClickOnDeletePackageButton() {
        packagesActions.clickOnDeletePkgBtn();
    }

    @And("I confrim the delete")
    public void iConfrimTheDelete() {
        packagesActions.clickOnConfirmDelete();
    }

    @Then("The {string} package will be deleted")
    public void thePackageWillBeDeleted(String pkgName) {
        Assert.assertFalse(packagesActions.checkThePackageDeletion(pkgName));

    }
}
