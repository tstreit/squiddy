#!/bin/bash
# Play VHS

# Make V4l2 look at composite video input
v4l2-ctl -i 2

# Play VHS
mplayer -vf pp=lb /dev/video0
