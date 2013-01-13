#!/bin/bash

# Quick script to start second conky instance.
# Written: 06/09/2012
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

conky &
sleep 20 &
conky -c ~/.conkyscripts/.conkyrc
