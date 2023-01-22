/**
* MoralAlignment enumeration
*
* Used to represent how the NPC aligns with common morality
* Stored in DB as string for ease of use, but stored as an enum in code for safety
* @author  Scott
* @version 0.1
* @since   2023-01-15
* @status Done
*/

package com.scottfarsace.spring.npcgenerator.models;

public enum MoralAlignment
{
    Good,
    Neutral,
    Evil
}
