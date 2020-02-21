package org.nanotek.service.dispatcher;

import org.nanotek.Base;
import org.nanotek.Dispatcher;
import org.nanotek.Transformer;

public interface EntityDispatcher<T,I extends Base> extends Dispatcher<I>, Transformer<T,I>{
}
