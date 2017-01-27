<a href="http://projectdanube.org/" target="_blank"><img src="http://projectdanube.github.com/xdi2/images/projectdanube_logo.png" align="right"></a>

## Sovrin Client (Java)

This is a **work-in-progress** Java client library for [Sovrin](https://github.com/sovrin-foundation/sovrin-client/). It is implemented using a foreign function interface (FFI) to a native library written in Rust.

Pull requests welcome!

**Not ready for production use! Not all commands work properly! Use at your own risk!**

### How to build

First, build the native "sovclient" library at https://github.com/sovrin-foundation/sovrin-client/tree/master/sovrin_client/client/lib:

	cargo build

Then copy the resulting `libsovclient.so` to `./lib/`.

Then run

    mvn clean install

### Example use

	public class Example {
	
		public static void main(String[] args) {
	
			SovrinClient client = new SovrinClientImpl("localhost:1234");
	
			try {
	
				int result = client.setDid("did:sov:21tDAKCERh95uGgKbJNHYp", "lji9qTtkCydxtez/bt1zdLxVMMbz4SzWvlqgOBmURoM=", null, null, "USER");
				System.out.println("setDid result: " + result);
			} finally {
	
				client.close();
			}
		}
	}

Output:

	0
