package eu.seebetter.ini.chips.seebetter20;


import net.sf.jaer.event.BasicEvent;
import net.sf.jaer.event.PolarityEvent;

/** This event class is used in the extractor to hold data from the sensor 
 * so that it can be logged to files and played back here. It adds the ADC sample value.
 * This event has the usual timestamp in us.
 */
public class PolarityADCSampleEvent extends PolarityEvent {

    /** The ADC sample value. Has value -1 by convention for non-sample events. */
    protected int adcSample = 0;
    
    /** Set if this event is a start bit event, e.g. start of frame sample. */
    protected boolean startOfFrame=false;
    
    /** This bit determines whether it is the first read (A) or the second read (B) of a pixel */
    protected boolean isB = false;

    public PolarityADCSampleEvent() {
    }

    /**
     * The ADC sample value.
     * @return the adcSample
     */
    public int getAdcSample() {
        return adcSample;
    }

    /**
     * Sets the ADC sample value.
     * 
     * @param adcSample the adcSample to set
     */
    public void setAdcSample(int adcSample) {
        this.adcSample = adcSample;
    }

    /**
     * Flags if this sample is from the start of the frame.
     * @return the startOfFrame
     */
    public boolean isStartOfFrame() {
        return startOfFrame;
    }

    /**
     * Flags if this sample is from the start of the frame.
    * 
     * @param startOfFrame the startOfFrame to set
     */
    public void setStartOfFrame(boolean startOfFrame) {
        this.startOfFrame = startOfFrame;
    }

    @Override
    public void copyFrom(BasicEvent src) {
        PolarityADCSampleEvent e = (PolarityADCSampleEvent) src;
        super.copyFrom(src);
        adcSample = e.getAdcSample();
        setStartOfFrame(e.isStartOfFrame());
    }

    /** Returns true if sample is non-negative.
     * 
     * @return true if this is an ADC sample
     */
    public boolean isAdcSample() {
        return adcSample>=0;
    }
    
    /** Returns true if sample is second sample.
     * 
     * @return false = A, true = B
     */
    public boolean getMode() {
        return isB;
    }
}