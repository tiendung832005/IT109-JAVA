package Bai4;

class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // Không làm gì vì Mp4Player chỉ hỗ trợ format mp4
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Đang phát file mp4. Tên file: " + fileName);
    }
}

