#!/bin/bash
# Capture and record VHS from composite video

# Ask what the file is to be called
echo Please enter a filename that you would like to the video,no extension needed?
read NAME

# Make V4l2 look at composite video input
v4l2-ctl -i 2

# Record video and dump to stream.dump
mplayer -vf pp=lb /dev/video0 -dumpstream /home/tstreit/scripts

# Rename the video from stream.dump to filename
mv /home/tstreit/scripts/stream.dump /home/tstreit/scripts/$NAME.mpeg

# Move video to vhs directory
mv /home/tstreit/scripts/$NAME.mpeg /home/tstreit/scripts/vhs/
