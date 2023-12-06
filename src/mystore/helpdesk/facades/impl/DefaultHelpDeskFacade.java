package mystore.helpdesk.facades.impl;

import java.util.PriorityQueue;
import java.util.Queue;
import mystore.helpdesk.entities.SupportTicket;
import mystore.helpdesk.facades.HelpDeskFacade;
import mystore.helpdesk.utils.CustomComparator;

public class DefaultHelpDeskFacade implements HelpDeskFacade {

  private Queue<SupportTicket> q = new PriorityQueue<>(new CustomComparator());

  @Override
  public void addNewSupportTicket(SupportTicket supportTicket) {
    q.offer(supportTicket);
  }

  @Override
  public SupportTicket getNextSupportTicket() {
    return q.poll();
  }

  @Override
  public int getNumberOfTickets() {
    return q.size();
  }
}
