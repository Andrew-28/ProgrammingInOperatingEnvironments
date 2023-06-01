package lab2.opengl;

import org.lwjgl.opengl.GL11;

/**
 * Pre-defined OpenGL types that should be available to various bindings
 * enumeration
 */
public enum GLType {
    /**
     * Bitdepth 8, Signed, 2's complement binary integer
     */
    BYTE(GL11.GL_BYTE, Byte.BYTES),
    /**
     * Bitdepth 8, Unsigned binary integer
     */
    UNSIGNED_BYTE(GL11.GL_UNSIGNED_BYTE, Byte.BYTES),
    /**
     * Bitdepth 16, Signed, 2's complement binary integer
     */
    SHORT(GL11.GL_SHORT, Short.BYTES),
    /**
     * Bitdepth 16, Unsigned binary integer
     */
    UNSIGNED_SHORT(GL11.GL_UNSIGNED_SHORT, Short.BYTES),
    /**
     * Bitdepth 32, Signed, 2's complement binary integer
     */
    INT(GL11.GL_INT, Integer.BYTES),
    /**
     * Bitdepth 32, Unsigned binary integer
     */
    UNSIGNED_INT(GL11.GL_UNSIGNED_INT, Integer.BYTES),
    /**
     * Bitdepth 32, An IEEE-754 floating-point value
     */
    FLOAT(GL11.GL_FLOAT, Float.BYTES),
    /**
     * Bitdepth 64, An IEEE-754 floating-point value
     */
    DOUBLE(GL11.GL_DOUBLE, Double.BYTES);

    private final int gl;
    private final int elementSize;

    private GLType(final int gl, final int size) {
        this.gl = gl;
        this.elementSize = size;
    }

    /**
     * Returns size of the type in bytes (8 bit per byte)
     *
     * @return size of the type in bytes
     */
    public int sizeOf() {
        return this.elementSize;
    }

    /**
     * Returns OpenGL enumeration value to pass into OpenGL functions
     *
     * @return OpenGL enumeration value
     */
    public int glEnum() {
        return this.gl;
    }

}
