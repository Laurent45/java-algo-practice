class RotationalCipher {

    private int key;

    RotationalCipher(int shiftKey) {
      if (shiftKey < 0 || shiftKey > 26) {
        throw new IllegalArgumentException("");
      }
      this.key = shiftKey;
    }

    String rotate(String data) {
      StringBuilder sb = new StringBuilder(data.length());

      for (char c : data.toCharArray()) {
        if (Character.isLetter(c)) {
          char base = Character.isLowerCase(c) ? 'a' : 'A';
          sb.append((char) (base + (c - base + key) % 26));
        } else {
          sb.append(c);
        }
      }

      return sb.toString();
    }

}
