package com.eu.evidence.rtdruid.internal.modules.jscan.common;


/**
 * Implements a linear inequality constraint (hyperplane). It may be
 * used to check whether a point belongs to a region or not. Different
 * objects <CODE>PlaneConstraint</CODE> are compared by the value in the field
 * <CODE>b</CODE>. The region is given by:
 *
 * <BLOCKQUOTE>
 * a<SUB>1</SUB>x<SUB>1</SUB> + a<SUB>2</SUB>x<SUB>2</SUB> + &#x2026;
 * + a<SUB>n</SUB>x<SUB>n</SUB> &#x2264; b
 * </BLOCKQUOTE>
 *
 * <P> This class implements the linear inequalities in the class
 * {@link HyperplanesAnalysis}.
 * @author <A href="http://feanor.sssup.it/~bini/">Enrico Bini</A>
 * @see <CODE>HyperplanesAnalysis</CODE>
 */
public class PlaneConstraint implements Comparable {

    /* The data fields are public to make easier the access */
    /**
     * Index of the constraint. When the constraint is used in the
     * hyperplanes analysis every bit of the index has the following
     * meaning: 0 means the left branch, 1 means the right
     * branch. When used in different context the user may define his
     * own usage.
     */
    /* Its data type may be BigInteger */
    public int index;
    /**
     * The coefficients of the linear inequality.
     */
    public int[] a;
    /**
     * The upper bound of the dot product.
     */
    public double b;
    
    /**
     * Constructs a newly allocated <CODE>PlaneConstraint</CODE>
     * object.
     * @param value the inequality bound.
     * @param coef the inequality coefficents.
     * @param i the index of this constraint.
     */
    public PlaneConstraint(double value, int[] coef, int i) {
		b = value;
		index = i;
		a = new int[coef.length];
		a = coef;
    }

    /**
     * Construct an empty <CODE>PlaneConstraint</CODE> object. This
     * object is useful only for comparing purpose.
     * @param value the inequality bound
     */
    public PlaneConstraint(double value) {
		b = value;
    }

    /**
     * Compares this object to the specified object. The result is
     * true if the object <CODE>PlaneConstraint</CODE> contains the
     * same value of this object in the b field.
     * @param constr the object to compare with.
     * @return <CODE>true</CODE> if the objects are the same,
     * <CODE>false</CODE> otherwise.
     */ 
    public boolean equals(PlaneConstraint constr) {
		 return (constr.b == b);
    }

    /**
     * Compares this <CODE>PlaneConstraint</CODE> object to another object.
     * @param o the object to be compared.
     * @return the value 0 if this <CODE>PlaneConstraint</CODE> is
     * equal to the argument; a value less than 0 if the
     * <CODE>b</CODE> field of this <CODE>PlaneConstraint</CODE>
     * is numerically less than the <CODE>b</CODE> field of the
     * argument; and a value greater than 0 otherwise.
     * @see Comparable
	 *
	 *	@throws ClassCastException if 'o' isn't a PlaneConstraint or a Double
     */
    public int compareTo(Object o) {
		double valore;
		if (o instanceof Double) {	// "o" is a PlaneConstraint
			valore = ((Double) o).doubleValue();
		} else {
			valore = ((PlaneConstraint)o).b;
		}
		
		if (b < valore)
			return -1;
		if (b > valore)
			return 1;
		//if (b == valore)
		return 0;
    }

    /**
     * Evaluates the dot product in the given point. If the given
     * vector <CODE>v</CODE> and the vector <CODE>a</CODE>, member
     * of the object, have different size, the dot product is compared
     * within the minimum size.
     * @param v the point to evaluate the dot product in.
     * @return the dot product.
     */
    public double planeValue(double[] v) {
		int i;
		double acc;
		
		acc = 0;
		if (a.length <= v.length) {
			for (i = 0; i < a.length; i++)
			acc += v[i]*a[i];
		} else {
			for (i = 0; i < v.length; i++)
			acc += v[i]*a[i];
		}
		return acc;
    }

    /**
     * Returns the difference between the dot product and
     * <CODE>b</CODE>, member of the object. If lower than or
     * equal to zero the given point satisfies the constraint.
     * @param v the given point.
     * @return the difference.
     */
    public double planeDistance(double[] v) {
		return planeValue(v) - b;
    }
    
    /**
     * True if the given point is cointained in the semispace.
     * @param v the given point.
     * @return <CODE>true</CODE> if the constraint is matched,
     * <CODE>false</CODE> otherwise.
     */
    public boolean planeCheck(double[] v) {
		return (planeDistance(v) <= 0);
    }

    /**
     * Converts this object into a string. First it is printed the
     * index in binary format and zero padded, then the coefficents
     * and last the field <CODE>b</CODE> of this object.
     * @return the string.
     */
    public String toString() {
		String s;
	
		//Integer ind = new Integer(index);
		s = new String(Integer.toBinaryString(index));
		while (s.length() < a.length-1) {
			s = "0"+s;
		}
		s = s+"\t";
		for(int i=0; i<a.length; i++) {
			s = s+String.valueOf(a[i])+" ";
		}
		s = s+ " \t"+String.valueOf(b);
		return s;
    }
};
