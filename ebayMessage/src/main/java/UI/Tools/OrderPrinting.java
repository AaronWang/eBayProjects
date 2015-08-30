package UI.Tools;

import handler.future.CallBackHandler;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import ExcelIO.AddressList;
import IO.Excel.ExcelFile;
import bean.Bean;
import bean.BuyerAddress;
import bean.callBean.CompleteSaleBean;
import bean.callBean.GetMyeBaySellingBean;
import bean.callBean.GetOrdersBean;
import bean.callBean.GetSellingManagerSaleRecordBean;
import bean.callBean.GetSellingManagerSoldListingsBean;

import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.ItemListCustomizationType;
import com.ebay.soap.eBLBaseComponents.OrderIDArrayType;
import com.ebay.soap.eBLBaseComponents.OrderStatusFilterCodeType;
import com.ebay.soap.eBLBaseComponents.OrderTransactionType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.SellingManagerSearchType;
import com.ebay.soap.eBLBaseComponents.SellingManagerSearchTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SellingManagerSoldListingsPropertyTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SellingManagerSoldListingsSortTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SellingManagerSoldOrderType;
import com.ebay.soap.eBLBaseComponents.SellingManagerSoldTransactionType;
import com.ebay.soap.eBLBaseComponents.SortOrderCodeType;
import com.ebay.soap.eBLBaseComponents.TransactionType;

import ebayApiCall.EbayCallAction;
import ebayClient.EbayClient;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import printingOrders.GeneratePDF;

import java.awt.Component;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

public class OrderPrinting extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	ArrayList<BuyerAddress> addresslist = new ArrayList<BuyerAddress>();
	ArrayList<String> orderIDArray = new ArrayList<String>();

	// List<OrderType> orders = new ArrayList<OrderType>();// getorders
	List<SellingManagerSoldOrderType> soldOrders = new ArrayList<SellingManagerSoldOrderType>();// sellingmanagerSoldOrders

	private JButton DownloadButton;
	private JButton CreatePDFButton;
	// private String accountName;
	private JCheckBox chckbxDownloadAllAccounts;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderPrinting dialog = new OrderPrinting();
					// dialog.setAccountName("aaroncollection2015");
					// dialog.setAccountName("onlyleaf520");
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// public String getAccountName() {
	// return accountName;
	// }
	//
	// public void setAccountName(String accountName) {
	// this.accountName = accountName;
	// }

	/**
	 * Create the dialog.
	 */
	public OrderPrinting() {
		setBounds(100, 100, 1092, 565);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			DownloadButton = new JButton("Download Orders");
			DownloadButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					addresslist.clear();
					orderIDArray.clear();
					table.updateUI();

					if (chckbxDownloadAllAccounts.isSelected() == true) {
						int length = comboBox.getModel().getSize();
						for (int i = 0; i < length; i++) {
							downloadOrders(comboBox.getModel().getElementAt(i).toString());
						}
					} else {
						downloadOrders(comboBox.getModel().getSelectedItem().toString());
					}
				}
			});
			DownloadButton.setActionCommand("OK");
			getRootPane().setDefaultButton(DownloadButton);
		}
		{
			CreatePDFButton = new JButton("CreatePDF");
			CreatePDFButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					GeneratePDF pdf = new GeneratePDF();
					AddressList list = new AddressList();
					list.setAddresslist(addresslist);
					pdf.setAddressList(list);
					pdf.currentTime();
					list.sortBySalesRecords();// sort by sales records for excel
												// file.(backup)
					// ---------------------------------------------------------------------

					ExcelFile excelFile = new ExcelFile(pdf.getCurrentTime() + ".xlsx");
					excelFile.setCellDetails(1, 0, "Sales Record Number");
					excelFile.setCellDetails(1, 1, "User Id");
					excelFile.setCellDetails(1, 2, "Buyer Fullname");
					excelFile.setCellDetails(1, 3, "Buyer Phone Number");
					excelFile.setCellDetails(1, 4, "Buyer Email");
					excelFile.setCellDetails(1, 5, "Buyer Address 1");
					excelFile.setCellDetails(1, 6, "Buyer Address 2");
					excelFile.setCellDetails(1, 7, "Buyer City");
					excelFile.setCellDetails(1, 8, "Buyer State");
					excelFile.setCellDetails(1, 9, "Buyer Postcode");
					excelFile.setCellDetails(1, 10, "Buyer Country");
					excelFile.setCellDetails(1, 11, "Item Number");
					excelFile.setCellDetails(1, 12, "Item Title");
					excelFile.setCellDetails(1, 13, "Custom Label");
					excelFile.setCellDetails(1, 14, "Quantity");
					excelFile.setCellDetails(1, 15, "Sale Price");
					excelFile.setCellDetails(1, 16, "Postage and Handling");
					excelFile.setCellDetails(1, 17, "Insurance");
					excelFile.setCellDetails(1, 18, "Cash on delivery fee");
					excelFile.setCellDetails(1, 19, "Total Price");
					excelFile.setCellDetails(1, 20, "Payment Method");
					excelFile.setCellDetails(1, 21, "Sale Date");
					excelFile.setCellDetails(1, 22, "Checkout Date");
					excelFile.setCellDetails(1, 23, "Paid on Date");
					excelFile.setCellDetails(1, 24, "Posted on Date");
					excelFile.setCellDetails(1, 25, "Feedback left");
					excelFile.setCellDetails(1, 26, "Feedback received");
					excelFile.setCellDetails(1, 27, "Notes to yourself");
					excelFile.setCellDetails(1, 28, "PayPal Transaction ID");
					excelFile.setCellDetails(1, 29, "Postage Service");
					excelFile.setCellDetails(1, 30, "Cash on delivery option");
					excelFile.setCellDetails(1, 31, "Transaction ID");
					excelFile.setCellDetails(1, 32, "Order ID");
					excelFile.setCellDetails(1, 33, "Variation Details");
					excelFile.setCellDetails(1, 34, "Global Shipping Program");
					excelFile.setCellDetails(1, 35, "Global Shipping Reference ID");
					excelFile.setCellDetails(1, 36, "Click and Collect");
					excelFile.setCellDetails(1, 37, "Click and Collect Reference #");
					excelFile.setCellDetails(1, 38, "Post To Address 1");
					excelFile.setCellDetails(1, 39, "Post To Address 2");
					excelFile.setCellDetails(1, 40, "Post To City");
					excelFile.setCellDetails(1, 41, "Post To State");
					excelFile.setCellDetails(1, 42, "Post To Postal Code");
					excelFile.setCellDetails(1, 43, "Post To Country");
					excelFile.setCellDetails(1, 44, "eBay Plus");
					int i = 3;

					for (BuyerAddress b : addresslist) {
						excelFile.setCellDetails(i, 0, b.salesRecordNumber);
						excelFile.setCellDetails(i, 2, b.buyername);
						excelFile.setCellDetails(i, 5, b.address1);
						excelFile.setCellDetails(i, 6, b.address2);
						excelFile.setCellDetails(i, 7, b.city);
						excelFile.setCellDetails(i, 8, b.state);
						excelFile.setCellDetails(i, 9, b.postcode);
						excelFile.setCellDetails(i, 13, b.customLabel);
						excelFile.setCellDetails(i, 14, b.quantity);
						i++;
					}
					excelFile.saveFile();
					// ---------------------------------------------------------------------
					pdf.addressList.sortOrders();
					pdf.pdfStyleB();
				}
			});
			CreatePDFButton.setActionCommand("Cancel");
		}

		JScrollPane scrollPane = new JScrollPane();

		class CustomTableModel extends AbstractTableModel {
			ArrayList<BuyerAddress> addresslist;

			// private String[] columnNames = { "ID", "Name", "Gender" };
			// private Class[] columnClass = { Integer.class, String.class,
			// String.class };

			CustomTableModel(ArrayList<BuyerAddress> list) {
				addresslist = list;
			}

			@Override
			public String getColumnName(int col) {
				switch (col) {
				case 0:
					return "Record";
				case 1:
					return "Name";
				case 2:
					return "Address1";
				case 3:
					return "Address2";
				case 4:
					return "City";
				case 5:
					return "State";
				case 6:
					return "Postcode";
				case 7:
					return "Quantity";
				case 8:
					return "Label";
				default:
					return "null";
				}
			}

			@Override
			public Object getValueAt(int row, int col) {
				// TODO Auto-generated method stub
				BuyerAddress buyer = addresslist.get(row);
				switch (col) {
				case 0:
					return buyer.salesRecordNumber;
				case 1:
					return buyer.buyername;
				case 2:
					return buyer.address1;
				case 3:
					return buyer.address2;
				case 4:
					return buyer.city;
				case 5:
					return buyer.state;
				case 6:
					return buyer.postcode;
				case 7:
					return buyer.quantity;
				case 8:
					return buyer.customLabel;
				default:
					return null;
				}
			}

			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return 9;
			}

			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return addresslist.size();
			}

		}

		CustomTableModel tableModel = new CustomTableModel(addresslist);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);

		JButton btnRemoveButton = new JButton("Remove");

		JButton MaskPostedButton = new JButton("Mark As Posted");
		MaskPostedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (String orderID : orderIDArray) {
					// System.out.println("Order ID : " + orderID);
					CompleteSaleBean b = new CompleteSaleBean();
					b.setMyUserID(comboBox.getModel().getSelectedItem().toString());
					b.setOrderID(orderID);
					b.setShipped(true);

					EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.COMPLETESALE, b, new CallBackHandler() {
						@Override
						public void handle(Bean bean) {
							// TODO Auto-generated method stub
						}
					});
				}
				DownloadButton.doClick();
			}
		});

		JButton btnNewButton = new JButton("SellingManagerPro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addresslist.clear();
				soldOrders.clear();
				orderIDArray.clear();
				// table.updateUI();

				GetSellingManagerSoldListingsBean getSellingManagerSoldListingsBean = new GetSellingManagerSoldListingsBean();
				getSellingManagerSoldListingsBean.setMyUserID(comboBox.getModel().getSelectedItem().toString());
				PaginationType page1 = new PaginationType();
				page1.setEntriesPerPage(100);
				page1.setPageNumber(1);
				getSellingManagerSoldListingsBean.setPagination(page1);
				getSellingManagerSoldListingsBean.setSort(SellingManagerSoldListingsSortTypeCodeType.SALES_RECORD_ID);
				getSellingManagerSoldListingsBean.setSortOrder(SortOrderCodeType.ASCENDING);

				getSellingManagerSoldListingsBean
						.setFilter(new SellingManagerSoldListingsPropertyTypeCodeType[] { SellingManagerSoldListingsPropertyTypeCodeType.PRINT_SHIPPING_LABEL });

				// getSellingManagerSoldListingsBean.setDetailLevel(new
				// DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL });
				class GetSellingManagerSoldListings_CallBackHandler extends CallBackHandler {

					@Override
					public void handle(Bean bean) {

						// TODO Auto-generated method stub
						GetSellingManagerSoldListingsBean b = (GetSellingManagerSoldListingsBean) bean;
						if (b.getReturnedSaleRecord() == null) {
							return;
						}

						for (SellingManagerSoldOrderType soldOrder : b.getReturnedSaleRecord()) {
							soldOrders.add(soldOrder);
							boolean questionMark = false;
							for (SellingManagerSoldTransactionType t : soldOrder.getSellingManagerSoldTransaction()) {
								if (t.getCustomLabel().contains("?")) {
									questionMark = true;
									break;
								}
							}
							if (questionMark) {
								soldOrders.remove(soldOrder);
								continue;
							}

							if (soldOrder.getSellingManagerSoldTransactionLength() == 1) {
								final BuyerAddress buyerAddress = new BuyerAddress();
								addresslist.add(buyerAddress);
								buyerAddress.orderID = soldOrder.getSellingManagerSoldTransaction(0).getOrderLineItemID();
								buyerAddress.salesRecordNumber = soldOrder.getSaleRecordID().toString();
								buyerAddress.buyername = soldOrder.getShippingAddress().getName();
								buyerAddress.postcode = soldOrder.getShippingAddress().getPostalCode();
								buyerAddress.quantity = soldOrder.getTotalQuantity().toString();
								buyerAddress.customLabel = soldOrder.getSellingManagerSoldTransaction(0).getCustomLabel();
								orderIDArray.add(soldOrder.getSellingManagerSoldTransaction(0).getOrderLineItemID());

								GetSellingManagerSaleRecordBean getSellingManagerSaleRecordBean = new GetSellingManagerSaleRecordBean();
								getSellingManagerSaleRecordBean.setMyUserID(comboBox.getModel().getSelectedItem().toString());
								getSellingManagerSaleRecordBean.setOrderID(soldOrder.getSellingManagerSoldTransaction(0).getOrderLineItemID());

								EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GetSellingManagerSaleRecord, getSellingManagerSaleRecordBean,
										new CallBackHandler() {

											@Override
											public void handle(Bean bean) {
												// TODO Auto-generated method

												GetSellingManagerSaleRecordBean b = (GetSellingManagerSaleRecordBean) bean;
												buyerAddress.address1 = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getStreet1();
												buyerAddress.address2 = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getStreet2();
												buyerAddress.city = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getCityName();
												buyerAddress.state = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getStateOrProvince();
												// table.updateUI();
											}
										});
							} else if (soldOrder.getSellingManagerSoldTransactionLength() > 1) {
								GetSellingManagerSoldListingsBean getSellingManagerSoldListingsBean = new GetSellingManagerSoldListingsBean();
								getSellingManagerSoldListingsBean.setMyUserID(comboBox.getModel().getSelectedItem().toString());
								PaginationType page1 = new PaginationType();
								page1.setEntriesPerPage(100);
								page1.setPageNumber(1);
								getSellingManagerSoldListingsBean.setPagination(page1);
								//
								getSellingManagerSoldListingsBean.setSort(SellingManagerSoldListingsSortTypeCodeType.SALES_RECORD_ID);
								//
								getSellingManagerSoldListingsBean.setSortOrder(SortOrderCodeType.ASCENDING);
								getSellingManagerSoldListingsBean
										.setFilter(new SellingManagerSoldListingsPropertyTypeCodeType[] { SellingManagerSoldListingsPropertyTypeCodeType.PRINT_SHIPPING_LABEL });
								SellingManagerSearchType search = new SellingManagerSearchType();
								search.setSearchType(SellingManagerSearchTypeCodeType.SALE_RECORD_ID);
								search.setSearchValue(soldOrder.getSaleRecordID().toString());
								getSellingManagerSoldListingsBean.setSearch(search);

								final BuyerAddress buyerAddress = new BuyerAddress();
								addresslist.add(buyerAddress);
								buyerAddress.orderID = "";
								buyerAddress.salesRecordNumber = soldOrder.getSaleRecordID().toString();
								buyerAddress.buyername = soldOrder.getShippingAddress().getName();
								buyerAddress.postcode = soldOrder.getShippingAddress().getPostalCode();
								buyerAddress.quantity = soldOrder.getTotalQuantity().toString();
								buyerAddress.customLabel = "";

								EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GetSellingManagerSoldListings, getSellingManagerSoldListingsBean,
										new CallBackHandler() {

											@Override
											public void handle(Bean bean) {
												// TODO Auto-generated method
												// stub
												GetSellingManagerSoldListingsBean b = (GetSellingManagerSoldListingsBean) bean;
												// buyerAddress.address1 =
												// b.getReturnedSaleRecord().getetShippingAddress().getStreet1();
												// buyerAddress.address2 =
												// b.getReturnedSaleRecord().getShippingAddress().getStreet2();
												// buyerAddress.city =
												// b.getReturnedSaleRecord().getShippingAddress().getCityName();
												// buyerAddress.state =
												// b.getReturnedSaleRecord().getShippingAddress().getStateOrProvince();
												// table.updateUI();
											}
										});

								for (SellingManagerSoldTransactionType t : soldOrder.getSellingManagerSoldTransaction()) {
									final BuyerAddress subBuyerAddress = new BuyerAddress();
									addresslist.add(subBuyerAddress);
									subBuyerAddress.orderID = t.getOrderLineItemID();
									subBuyerAddress.salesRecordNumber = soldOrder.getSaleRecordID().toString();
									subBuyerAddress.buyername = soldOrder.getShippingAddress().getName();
									subBuyerAddress.postcode = soldOrder.getShippingAddress().getPostalCode();
									subBuyerAddress.quantity = soldOrder.getTotalQuantity().toString();
									subBuyerAddress.customLabel = t.getCustomLabel();
									orderIDArray.add(t.getOrderLineItemID());

									GetSellingManagerSaleRecordBean getSellingManagerSaleRecordBean = new GetSellingManagerSaleRecordBean();
									getSellingManagerSaleRecordBean.setMyUserID(comboBox.getModel().getSelectedItem().toString());
									getSellingManagerSaleRecordBean.setOrderID(t.getOrderLineItemID());

									EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GetSellingManagerSaleRecord, getSellingManagerSaleRecordBean,
											new CallBackHandler() {

												@Override
												public void handle(Bean bean) {
													// TODO Auto-generated
													// method

													GetSellingManagerSaleRecordBean b = (GetSellingManagerSaleRecordBean) bean;
													if (b.getReturnedSellingManagerSoldOrder().getShippingAddress() == null)
														return;
													subBuyerAddress.address1 = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getStreet1();
													subBuyerAddress.address2 = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getStreet2();
													subBuyerAddress.city = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getCityName();
													subBuyerAddress.state = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getStateOrProvince();
													// table.updateUI();
												}
											});
								}
							}
						}
						if (b.getPagination().getPageNumber() < b.getReturnedPaginationResult().getTotalNumberOfPages()) {
							b.getPagination().setPageNumber(b.getPagination().getPageNumber() + 1);
							EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GetSellingManagerSoldListings, b,
									new GetSellingManagerSoldListings_CallBackHandler());
						}
						// else
						// table.updateUI();
					}
				}
				EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GetSellingManagerSoldListings, getSellingManagerSoldListingsBean,
						new GetSellingManagerSoldListings_CallBackHandler());
			}
		});

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "aaroncollection2015", "onlyleaf520" }));

		chckbxDownloadAllAccounts = new JCheckBox("DownLoad all Accounts");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPanel
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(chckbxDownloadAllAccounts, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(DownloadButton, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
										.addComponent(btnRemoveButton, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
										.addComponent(CreatePDFButton, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
										.addComponent(MaskPostedButton, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(18)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE).addGap(0)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_contentPanel.createSequentialGroup().addContainerGap()
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(15).addComponent(DownloadButton)
								.addGap(26).addComponent(btnRemoveButton).addGap(24).addComponent(CreatePDFButton).addGap(34).addComponent(MaskPostedButton).addGap(89)
								.addComponent(chckbxDownloadAllAccounts).addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE).addComponent(btnNewButton).addGap(58))
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(1).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE).addGap(1)));
		gl_contentPanel.linkSize(SwingConstants.HORIZONTAL, new Component[] { DownloadButton, CreatePDFButton, btnRemoveButton, MaskPostedButton });
		contentPanel.setLayout(gl_contentPanel);

	}

	public void downloadOrders(final String account) {
		GetMyeBaySellingBean beanInput = new GetMyeBaySellingBean();

		ItemListCustomizationType soldList = new ItemListCustomizationType();
		soldList.setDurationInDays(50);
		soldList.setInclude(true);
		soldList.setIncludeNotes(true);
		soldList.setOrderStatusFilter(OrderStatusFilterCodeType.AWAITING_SHIPMENT);
		PaginationType page = new PaginationType();
		page.setEntriesPerPage(100);
		page.setPageNumber(1);
		soldList.setPagination(page);
		beanInput.setHideVariations(true);
		beanInput.setSoldList(soldList);
		// beanInput.setDetailLevel(DetailLevelCodeType.RETURN_ALL);
		beanInput.setMyUserID(account);
		// beanInput.setMyUserID("onlyleaf520");
		class GetMyEbaySelling_CallBackHandler extends CallBackHandler {

			@Override
			public void handle(Bean bean) {
				// TODO Auto-generated method stub
				GetMyeBaySellingBean b = (GetMyeBaySellingBean) bean;
				if (b.getReturnedSoldList() == null) {
					// table.updateUI();
					return;
				}

				for (OrderTransactionType t : b.getReturnedSoldList().getOrderTransactionArray().getOrderTransaction()) {
					if (t.getTransaction() == null) {
						orderIDArray.add(t.getOrder().getOrderID());
					} else {
						orderIDArray.add(t.getTransaction().getOrderLineItemID());
					}
				}
				// for (String s : orderIDArray) {
				// System.out.println(s);
				// }
				if (b.getSoldList().getPagination().getPageNumber() < b.getReturnedSoldList().getPaginationResult().getTotalNumberOfPages()) {
					b.getSoldList().getPagination().setPageNumber(b.getSoldList().getPagination().getPageNumber() + 1);
					EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GETMYEBAYSELLING, b, new GetMyEbaySelling_CallBackHandler());
				} else {
					for (String orderID : orderIDArray) {
						final BuyerAddress buyerAddress = new BuyerAddress();
						addresslist.add(buyerAddress);
						buyerAddress.orderID = orderID;

						GetSellingManagerSaleRecordBean getSellingManagerSaleRecordBean = new GetSellingManagerSaleRecordBean();
						getSellingManagerSaleRecordBean.setMyUserID(account);
						getSellingManagerSaleRecordBean.setOrderID(orderID);

						EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GetSellingManagerSaleRecord, getSellingManagerSaleRecordBean, new CallBackHandler() {

							@Override
							public void handle(Bean bean) {
								// TODO Auto-generated
								// method
								GetSellingManagerSaleRecordBean b = (GetSellingManagerSaleRecordBean) bean;
								buyerAddress.buyername = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getName();
								buyerAddress.address1 = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getStreet1();
								buyerAddress.address2 = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getStreet2();
								buyerAddress.city = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getCityName();
								buyerAddress.state = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getStateOrProvince();
								buyerAddress.postcode = b.getReturnedSellingManagerSoldOrder().getShippingAddress().getPostalCode();
								buyerAddress.salesRecordNumber = b.getReturnedSellingManagerSoldOrder().getSaleRecordID().toString();
								if (b.getReturnedSellingManagerSoldOrder().getSellingManagerSoldTransactionLength() == 1) {

									buyerAddress.quantity = b.getReturnedSellingManagerSoldOrder().getSellingManagerSoldTransaction(0).getQuantitySold().toString();
									// -----------------
									GetSellingManagerSoldListingsBean getSellingManagerSoldListingsBean = new GetSellingManagerSoldListingsBean();
									getSellingManagerSoldListingsBean.setMyUserID(account);

									getSellingManagerSoldListingsBean
											.setFilter(new SellingManagerSoldListingsPropertyTypeCodeType[] { SellingManagerSoldListingsPropertyTypeCodeType.PRINT_SHIPPING_LABEL });
									SellingManagerSearchType search = new SellingManagerSearchType();
									search.setSearchType(SellingManagerSearchTypeCodeType.SALE_RECORD_ID);
									search.setSearchValue(buyerAddress.salesRecordNumber);
									getSellingManagerSoldListingsBean.setSearch(search);
									EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GetSellingManagerSoldListings, getSellingManagerSoldListingsBean,
											new CallBackHandler() {

												@Override
												public void handle(Bean bean) {
													// TODO
													// Auto-generated
													GetSellingManagerSoldListingsBean b = (GetSellingManagerSoldListingsBean) bean;
													buyerAddress.customLabel = b.getReturnedSaleRecord()[0].getSellingManagerSoldTransaction(0).getCustomLabel();
													if (buyerAddress.customLabel.contains("?")) {
														orderIDArray.remove(buyerAddress.orderID);
														addresslist.remove(buyerAddress);
													}
													SwingUtilities.invokeLater(new Runnable() {

														@Override
														public void run() {
															// TODO
															// Auto-generated
															// method stub
															table.updateUI();
														}
													});
												}
											});

								} else if (b.getReturnedSellingManagerSoldOrder().getSellingManagerSoldTransactionLength() > 1) {
									Integer total = 0;
									for (SellingManagerSoldTransactionType t : b.getReturnedSellingManagerSoldOrder().getSellingManagerSoldTransaction()) {
										total += t.getQuantitySold();
									}
									buyerAddress.quantity = total.toString();
									buyerAddress.customLabel = "";

									// -----------------
									GetSellingManagerSoldListingsBean getSellingManagerSoldListingsBean = new GetSellingManagerSoldListingsBean();
									getSellingManagerSoldListingsBean.setMyUserID(account);

									getSellingManagerSoldListingsBean
											.setFilter(new SellingManagerSoldListingsPropertyTypeCodeType[] { SellingManagerSoldListingsPropertyTypeCodeType.PRINT_SHIPPING_LABEL });
									SellingManagerSearchType search = new SellingManagerSearchType();
									search.setSearchType(SellingManagerSearchTypeCodeType.SALE_RECORD_ID);
									search.setSearchValue(buyerAddress.salesRecordNumber);
									getSellingManagerSoldListingsBean.setSearch(search);
									EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GetSellingManagerSoldListings, getSellingManagerSoldListingsBean,
											new CallBackHandler() {

												@Override
												public void handle(Bean bean) {
													// TODO
													// Auto-generated
													GetSellingManagerSoldListingsBean b = (GetSellingManagerSoldListingsBean) bean;
													boolean questionMark = false;
													for (SellingManagerSoldTransactionType t : b.getReturnedSaleRecord()[0].getSellingManagerSoldTransaction()) {
														if (t.getCustomLabel().contains("?")) {
															questionMark = true;
															break;
														}
													}
													if (questionMark) {
														orderIDArray.remove(buyerAddress.orderID);
														addresslist.remove(buyerAddress);
														return;
													}

													for (SellingManagerSoldTransactionType s : b.getReturnedSaleRecord()[0].getSellingManagerSoldTransaction()) {
														BuyerAddress subbuyerAddress = new BuyerAddress();
														addresslist.add(subbuyerAddress);
														subbuyerAddress.orderID = buyerAddress.orderID;
														subbuyerAddress.salesRecordNumber = buyerAddress.salesRecordNumber;
														subbuyerAddress.quantity = s.getQuantitySold().toString();
														subbuyerAddress.customLabel = s.getCustomLabel();
														subbuyerAddress.buyername = "";
														subbuyerAddress.address1 = "";
														subbuyerAddress.address2 = "";
														subbuyerAddress.state = "";
													}
													SwingUtilities.invokeLater(new Runnable() {

														@Override
														public void run() {
															// TODO
															// Auto-generated
															// method stub
															table.updateUI();
														}
													});
												}
											});
								}
							}
						});
					}
				}
			}
		}
		EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GETMYEBAYSELLING, beanInput, new GetMyEbaySelling_CallBackHandler());
	}

	public ArrayList<BuyerAddress> getAddresslist() {
		return addresslist;
	}

	public void setAddresslist(ArrayList<BuyerAddress> addresslist) {
		this.addresslist = addresslist;
	}
}
