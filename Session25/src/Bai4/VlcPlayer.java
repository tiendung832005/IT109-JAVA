package Bai4;

class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Đang phát file vlc. Tên file: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // Không làm gì vì VlcPlayer chỉ hỗ trợ format vlc
    }
}
