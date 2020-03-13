package org.nanotek;

import java.io.Serializable;

public interface BarCode<K extends Serializable> extends Base{
   K getBarCode();
   void setBarCode(K k);
}
