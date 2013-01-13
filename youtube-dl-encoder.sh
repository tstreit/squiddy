#!/bin/bash
# Must have FFMPEG installed, works best with version 0.10.6.1 with all the codec installed.
# Must also have youtube-dl installed.

# Create temporary folder to do work in.
mkdir $HOME/temp
CAPDIR="$HOME/temp/"

# Get Youtube video.
echo Copy and paste Youtube URL that you want to download here:
read YOUTUBE

# Get the name that you want to call the video.
echo What is the name of the video:
read NAME

# Where in the home directory do you want to store the video.
echo Where in your home directory do you want to store the video:
read DIRECTORY

# Download Youtube video.
cd $CAPDIR
youtube-dl -t $YOUTUBE

# Convert video into MP4 and move converted video to specified directory.
for FILE in $CAPDIR/*
do
ffmpeg -i $FILE -acodec libmp3lame -ab 128k -ac 2 -vcodec libx264 -s hd720 -crf 22 -threads 0 $NAME.mp4
cp $NAME.mp4 $HOME/$DIRECTORY/
done

# Remove temporary folder.
rm -Rf $CAPDIR
