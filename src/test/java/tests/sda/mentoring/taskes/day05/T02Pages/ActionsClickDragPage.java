package tests.sda.mentoring.taskes.day05.T02Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.Driver;

public class ActionsClickDragPage {
    private By doubleClickBtn = By.id("doubleClickButton");
    private By rightClickBtn = By.id("showSuccessButton");
    private By hoverBtn = By.id("hoverButton");
    private By draggable = By.xpath("//div//div[@id= 'drag1']");
    private By droppable = By.xpath("//div//div[@id= 'drop1']");
    private By dragSuccessMessage = By.id("dragSuccessMessage");
    private By rightClickSuccessMessage = By.id("rightClickSuccessMessage");
    private By doubleClickSuccessMessage = By.id("doubleClickSuccessMessage");
    private By hoverSuccessMessage = By.id("hoverSuccessMessage");

    private Actions actions;

    public ActionsClickDragPage() {

        this.actions = new Actions(Driver.getDriver());
    }

    public ActionsClickDragPage performDoubleClick() {
        WebElement btn = Driver.getDriver().findElement(doubleClickBtn);
        actions.doubleClick(btn).perform();
        Assert.assertTrue(Driver.getDriver().findElement(doubleClickSuccessMessage).isDisplayed());
        return this;
    }

    public ActionsClickDragPage performRightClick() {
        WebElement btn = Driver.getDriver().findElement(rightClickBtn);
        actions.contextClick(btn).perform();
        Assert.assertTrue(Driver.getDriver().findElement(rightClickSuccessMessage).isDisplayed());
        return this;
    }

    public ActionsClickDragPage performDragAndDrop() {
        WebElement source = Driver.getDriver().findElement(draggable);
        WebElement target = Driver.getDriver().findElement(droppable);
        actions.dragAndDrop(source, target).perform();
        Assert.assertTrue(Driver.getDriver().findElement(dragSuccessMessage).isDisplayed());
        return this;
    }

    public ActionsClickDragPage performHover() {
        WebElement btn = Driver.getDriver().findElement(hoverBtn);
        actions.moveToElement(btn).perform();
        Assert.assertTrue(Driver.getDriver().findElement(hoverSuccessMessage).isDisplayed());
        return this;
    }

}
