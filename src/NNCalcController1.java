import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author A. Singh
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE);

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {

        //Accessing top and bottom natural number
        NaturalNumber top = model.top();
        NaturalNumber bottom = model.bottom();

        //Subtract
        int isGreater = bottom.compareTo(top);
        if (isGreater <= 0) {
            view.updateSubtractAllowed(true);
        } else {
            view.updateSubtractAllowed(false);
        }

        //Divide
        boolean isZero = bottom.isZero();
        if (!isZero) {
            view.updateDivideAllowed(true);
        } else {
            view.updateDivideAllowed(false);
        }

        //Power
        int isGreaterForPower = bottom.compareTo(INT_LIMIT);
        if (isGreaterForPower <= 0) {
            view.updatePowerAllowed(true);
        } else {
            view.updatePowerAllowed(false);
        }

        //Root
        int isGreaterTwo = TWO.compareTo(bottom);
        int isGreaterLimit = bottom.compareTo(INT_LIMIT);
        if (isGreaterTwo <= 0 && isGreaterLimit <= 0) {
            view.updateRootAllowed(true);
        } else {
            view.updateRootAllowed(false);
        }

        //Updating view
        view.updateTopDisplay(top);
        view.updateBottomDisplay(bottom);
    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;

        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {

        //Top copies from Bottom
        this.model.top().copyFrom(this.model.bottom());

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddEvent() {

        //Top gets cleared and
        //the old value of Top is added to Bottom
        NaturalNumber temp = this.model.top().newInstance();
        temp.transferFrom(this.model.top());
        temp.add(this.model.bottom());
        this.model.bottom().transferFrom(temp);

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSubtractEvent() {

        //Top gets cleared and
        //Bottom contains the old value of Top minus old value of Bottom
        NaturalNumber temp = this.model.top().newInstance();
        temp.transferFrom(this.model.top());
        temp.subtract(this.model.bottom());
        this.model.bottom().transferFrom(temp);

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processMultiplyEvent() {

        //Top gets cleared and
        //Bottom contains the old value of Top times the old value of Bottom
        NaturalNumber temp = this.model.top().newInstance();
        temp.transferFrom(this.model.top());
        temp.multiply(this.model.bottom());
        this.model.bottom().transferFrom(temp);

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processDivideEvent() {

        //Top contains the remainder of old value of Top divided by old value of Bottom
        //And Bottom contains the quotient of the operation
        NaturalNumber remainder = this.model.top().divide(this.model.bottom());
        this.model.bottom().transferFrom(this.model.top());
        this.model.top().transferFrom(remainder);

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processPowerEvent() {

        //Top gets cleared and
        //Bottom contains the old value of Top raised to the power of old value of Bottom
        NaturalNumber temp = this.model.top().newInstance();
        temp.transferFrom(this.model.top());
        temp.power(this.model.bottom().toInt());
        this.model.bottom().transferFrom(temp);

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processRootEvent() {

        //Top gets cleared
        //Bottom contains the root of old value of Top based on old value of Bottom
        NaturalNumber temp = this.model.top().newInstance();
        temp.transferFrom(this.model.top());
        temp.root(this.model.bottom().toInt());
        this.model.bottom().transferFrom(temp);

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddNewDigitEvent(int digit) {

        //The digit passed gets appended to the Bottom
        this.model.bottom().multiplyBy10(digit);

        updateViewToMatchModel(this.model, this.view);
    }

}
