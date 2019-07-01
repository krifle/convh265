# 기능
- 경로를 입력 받아 해당 tree 를 탐색
- 대상 모든 영상파일에 대하여
    + mediainfo 로 파일 정보 추출
    + h.265 코덱이 아닐 경우 two pass 로 재인코딩 진행
    + 기존에 파일은 삭제 및 two pass

# input
```
java -jar target/convh265-0.0.1-SNAPSHOT.jar [base-path]
```

# ffmpeg
```
ffmpeg -i input -c:v libx265 -crf 28 -c:a aac -b:a 128k output.mp4
```
