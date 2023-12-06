package mystore.helpdesk.entities.impl;

import mystore.entities.User;
import mystore.helpdesk.entities.Priority;
import mystore.helpdesk.entities.RequestType;
import mystore.helpdesk.entities.SupportTicket;

public class DefaultSupportTicket implements SupportTicket {

  private String description;
  private User user;
  private RequestType type;
  private int ticketNumber;
  private static int counter = 1;

  public DefaultSupportTicket(User user, String description, RequestType type) {
    this.user = user;
    this.description = description;
    this.type = type;
    ticketNumber = counter++;
  }

  @Override
  public Priority getPriority() {
    return this.type.getPriority();
  }

  @Override
  public int getSequentialNumber() {
    return ticketNumber;
  }

  @Override
  public RequestType getRequestType() {
    return type;
  }
}
