ps -fu $USER| grep "Spring" | grep -v "grep" | awk '{print $2}' | xargs kill
exit 0



