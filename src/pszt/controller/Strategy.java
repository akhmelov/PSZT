/**
 * 
 */
package pszt.controller;

import pszt.common.events.MyEvent;

/**
 * @author pk
 *
 */
abstract class Strategy
{
	public abstract void perform(MyEvent event);
}
