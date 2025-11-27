# SimpleSong - MIDI Java Player

**SimpleSong** は、Java の `javax.sound.midi` パッケージを使用して、曲「lilac / Mrs. GREEN APPLE」を再現するシンプルな MIDI プレイヤーです。  
複数のメロディーとコードを組み合わせて再生することができます。

---

## 🎵 曲情報

- 曲名: **lilac**  
- アーティスト: **Mrs. GREEN APPLE**  
- プログラムはメロディとベースライン（melody3）を含む構成で再生します。

---

## 💻 実行環境

- Java 8 以上
- `javax.sound.midi` が使用可能な環境（標準 Java ライブラリ）

---

## ⚡ 使い方

1. リポジトリをクローンまたはダウンロード
    ```bash
    git clone https://github.com/yourusername/SimpleSong.git
    cd SimpleSong
    ```

2. `SimpleSong.java` をコンパイル
    ```bash
    javac SimpleSong.java
    ```

3. プログラムを実行
    ```bash
    java SimpleSong
    ```

> 実行すると、Java 内蔵の MIDI シンセサイザーで曲が再生されます。

---

## 🛠️ プログラム概要

- **メロディ**  
  - `melody1`, `melody2`：主旋律  
  - `melody3`：サポート旋律・ベースライン

- **コード進行**  
  - Gm7 → Dm7 → EbM7 → Bb（ループ）

- **テンポ設定**  
  - BPM は `tempo` で設定（現在 600 ミリ秒/ビート）

- **特徴**  
  - 複数ノートの同時再生に対応
  - サスティンペダル（Sustain）を使用して自然な響きを実現

---

## 🔧 カスタマイズ

- テンポ変更:
    ```java
    int tempo = 600; // 4*BPM, ミリ秒単位
    ```
- メロディやコードの追加:
    ```java
    int[][][] melody1 = { ... };
    int[][] chords = { ... };
    ```
- 使用する MIDI チャンネルの変更:
    ```java
    channels[0].programChange(0); // ピアノに変更
    ```

---

## 📌 注意

- このプログラムは Java の標準 MIDI サウンドを使用します。音色や音量は環境によって異なる場合があります。
- GUI はありません。コマンドラインからの再生専用です。

---

## 📝 ライセンス

MIT License  

