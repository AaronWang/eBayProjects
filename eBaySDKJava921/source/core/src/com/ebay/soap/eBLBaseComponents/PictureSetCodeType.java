
package com.ebay.soap.eBLBaseComponents;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PictureSetCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PictureSetCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Standard"/>
 *     &lt;enumeration value="Supersize"/>
 *     &lt;enumeration value="Large"/>
 *     &lt;enumeration value="CustomCode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * Note: Per JAXB standards, underscores are added to separate words in enumerations (e.g., PayPal becomes PAY_PAL).
 */
@XmlType(name = "PictureSetCodeType")
@XmlEnum
public enum PictureSetCodeType {


    /**
     * 
     *             Default value for requests. The size for the standard, 3-picture set for item pictures.
     *           
     * 
     */
    @XmlEnumValue("Standard")
    STANDARD("Standard"),

    /**
     * 
     *             The size for a 4-picture set.
     *             If you specify this value in the request and it is returned
     *             in the response, then in <b>AddItem</b> or a related call, you must specify <b>Item.PictureDetails.PhotoDisplay.Supersize</b> or <b>Item.PictureDetails.PhotoDisplay.PicturePack</b>.
     *           
     * 
     */
    @XmlEnumValue("Supersize")
    SUPERSIZE("Supersize"),

    /**
     * 
     *             This field is no longer returned.
     *           
     * 
     */
    @XmlEnumValue("Large")
    LARGE("Large"),

    /**
     * 
     *             Reserved for internal use ONLY.
     *           
     * 
     */
    @XmlEnumValue("CustomCode")
    CUSTOM_CODE("CustomCode");
    private final String value;

    PictureSetCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PictureSetCodeType fromValue(String v) {
        for (PictureSetCodeType c: PictureSetCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
