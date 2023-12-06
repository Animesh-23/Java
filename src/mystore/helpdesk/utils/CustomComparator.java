package mystore.helpdesk.utils;

import java.util.Comparator;
import mystore.helpdesk.entities.SupportTicket;

public class CustomComparator implements Comparator<SupportTicket> {

  @Override
  public int compare(SupportTicket o1, SupportTicket o2) {
    if (o1.getPriority().getImp() == o2.getPriority().getImp()) {
      return o2.getSequentialNumber() - o1.getSequentialNumber() < 0 ? -1 : 1;
    } else {
      return o1.getSequentialNumber() - o2.getSequentialNumber() < 0 ? -1 : 1;
    }
  }
}
