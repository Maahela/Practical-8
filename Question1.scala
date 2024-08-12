object CaesarCipher {
  
  def encryptCaesar(plaintext: String, shift: Int): String = {
    val offset = shift % 26
    plaintext.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        ((char - base + offset) % 26 + base).toChar
      } else {
        char
      }
    }
  }

  def decryptCaesar(ciphertext: String, shift: Int): String = {
    val offset = shift % 26
    ciphertext.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        ((char - base - offset + 26) % 26 + base).toChar
      } else {
        char
      }
    }
  }
}

object Cipher {

  def process(text: String, shift: Int, mode: String): String = {
    mode.toLowerCase match {
      case "encrypt" => CaesarCipher.encryptCaesar(text, shift)
      case "decrypt" => CaesarCipher.decryptCaesar(text, shift)
      case _ => throw new IllegalArgumentException("Mode should be 'encrypt' or 'decrypt'")
    }
  }

  def main(args: Array[String]): Unit = {
    val plaintext = "Hello, World!"
    val shift = 3


    val encryptedText = process(plaintext, shift, "encrypt")
    println(s"Encrypted Text: $encryptedText")


    val decryptedText = process(encryptedText, shift, "decrypt")
    println(s"Decrypted Text: $decryptedText")
  }
}
