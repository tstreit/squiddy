#!/bin/bash

# Quick script to get the name of the current network interface for Red hat 6/Fedora 15 new naming scheme.
# Then change .conkyrc config file with new network interface name.
# Written: 09/23/2011
# Author: Ted Streit
# Assisted by: Phillip Sugg, Copyright Phillip Sugg, 2011 used with permission to relicense as GPLv3
# Additional Comments: dekyos is awesome

IFACE=`lshw -quiet -class network | grep 'logical name:' | awk '{print $3}'`
sed -i 's/eth0/'"$IFACE"'/g' ~/.conkyrc
