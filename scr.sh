#!/bin/bash

echo 'Enter way to folder: '
echo -n '/home/student/'
read copyFrom
cd $copyFrom
filesForCopy=$(ls)
echo Files and folders for backup:  $filesForCopy

cd /home/student

backupFolderName=backup_$(date +"%d%m%y")

if [ ! -d "$backupFolderName" ]; then
	mkdir $backupFolderName
	touch log.txt
fi

cd /home/student/$copyFrom

cp -r $filesForCopy  /home/student/$backupFolderName

echo Success!
cd /home/student/$backupFolderName
echo Backup success at $(date +"%H:%M:%S") from $copyFrom >> log.txt



