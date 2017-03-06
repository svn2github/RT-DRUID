/* ###*B*###
 * ERIKA Enterprise - a tiny RTOS for small microcontrollers
 *
 * Copyright (C) 2002-2012  Evidence Srl
 *
 * This file is part of ERIKA Enterprise.
 *
 * ERIKA Enterprise is free software; you can redistribute it
 * and/or modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation, 
 * (with a special exception described below).
 *
 * Linking this code statically or dynamically with other modules is
 * making a combined work based on this code.  Thus, the terms and
 * conditions of the GNU General Public License cover the whole
 * combination.
 *
 * As a special exception, the copyright holders of this library give you
 * permission to link this code with independent modules to produce an
 * executable, regardless of the license terms of these independent
 * modules, and to copy and distribute the resulting executable under
 * terms of your choice, provided that you also meet, for each linked
 * independent module, the terms and conditions of the license of that
 * module.  An independent module is a module which is not derived from
 * or based on this library.  If you modify this code, you may extend
 * this exception to your version of the code, but you are not
 * obligated to do so.  If you do not wish to do so, delete this
 * exception statement from your version.
 *
 * ERIKA Enterprise is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License version 2 for more details.
 *
 * You should have received a copy of the GNU General Public License
 * version 2 along with ERIKA Enterprise; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA 02110-1301 USA.
 * ###*E*### */
//--------------------------------------------------------------------------
// Includes
//--------------------------------------------------------------------------
#include "ee.h"

//--------------------------------------------------------------------------
// Tasks
//--------------------------------------------------------------------------
/* Task1 toggles LED1(P0_11) on the StarterKit */
TASK(Task1)
{
	EE_y_ask_rh850f1x_led_toggle(LED1);
	TerminateTask();
}

/* Task1 toggles LED2(P8_5) on the StarterKit */
TASK(Task2)
{
	EE_y_ask_rh850f1x_led_toggle(LED2);
	TerminateTask();
}

//--------------------------------------------------------------------------
// Interrupt Functions
//--------------------------------------------------------------------------
/* INTOSTM0 is the 1ms timer tick interrupt to increment SystemTimer */
#ifdef __IAR__
#define intvect _Pragma ("vector = 0x0054") /* INTOSTM0 is at location 0x0054 of the IAR F1H interrupt vector table */
#endif
ISR2(OSTM0)
{
	IncrementCounter(SystemTimer);
}

//--------------------------------------------------------------------------
// Hooks
//--------------------------------------------------------------------------
void StartupHook(void)
{
	EE_rh850_clock_init(); /* Setup 80MHz Clock */

  /* Port initialization for Board LED usage */
	EE_y_ask_rh850f1x_led_init(LED1);
	EE_y_ask_rh850f1x_led_init(LED2);
	
	SetAbsAlarm(Alarm1,1,50); /* Execute Task1 every 50ms */
	SetAbsAlarm(Alarm2,1,250);/* Execute Task2 every 250ms */
	
	/* Configure 1ms timer interrupt */
	EE_rh850_timer_ms_init();
	EE_rh850_timer_int_enable();
	EE_rh850_timer_ms_start();
}

//--------------------------------------------------------------------------
// Main function 
//--------------------------------------------------------------------------
int main(void)
{
	StartOS(OSDEFAULTAPPMODE);
	return 0;
}
