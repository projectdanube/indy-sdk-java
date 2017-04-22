<a href="https://sovrin.org/" target="_blank"><img src="https://avatars2.githubusercontent.com/u/22057628?v=3&s=50" align="right"></a>

## Sovrin for Java

This is a **work-in-progress** Java client library for [Sovrin](https://sovrin.org/). It is implemented using a foreign function interface (FFI) to a native library written in Rust.

Pull requests welcome!

**Not ready for production use! Not all commands work properly! Use at your own risk!**

### How to build

First, build the native "sovrin" library at https://github.com/evernym/sovrin-client-rust:

	cargo build

Then copy the resulting `libsovrin.so` to `./lib/`.

Then run

    mvn clean install

### Example use

	TODO

Output:

	TODO
