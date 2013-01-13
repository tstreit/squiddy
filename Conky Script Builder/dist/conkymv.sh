#!/bin/bash

# Quick script to backup current .conkyrc file and replace new config that has been generated.
# Written: 09/23/2011
# Autbhor: Ted Streit

FILE=.conkyrc_org

if [-f $FILE]

then
	cp ~/.conkyrc ~/.conkyrc_org
	cp ~/.conkyrc_org ~/.conkyrc_bak
	mv conkyrc ~/.conkyrc
else
	cp ~/.conkyrc ~/.conkyrc_bak
	mv conkyrc ~/.conkyrc
fi
