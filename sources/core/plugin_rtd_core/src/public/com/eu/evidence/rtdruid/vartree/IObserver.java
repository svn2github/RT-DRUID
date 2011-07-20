package com.eu.evidence.rtdruid.vartree;

/**	Interface used to observe a {@link com.eu.evidence.rtdruid.internal.vartree.Element Element}
 * 
 * NOTE : very OLD !!!
 * 
 * @author Nicola Serreli
*/
public interface IObserver {

	/**	Tell that maybe something is change into the Element identified by path (or in its descendants).
	*
	*	@param	path	 identifies the element into tree. A null path identifies the root.
	*/
	public void handler(String path);

}
