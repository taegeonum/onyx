package edu.snu.vortex.runtime;

import java.util.List;

public class MemoryChannel extends Channel {
  List data;

  @Override
  public void write(List data) {
    System.out.println("Memory Channel WRITE: " + data);
    this.data = data;
  }

  @Override
  public List read() {
    System.out.println("Memory Channel READ: " + data);
    return this.data;
  }
}
