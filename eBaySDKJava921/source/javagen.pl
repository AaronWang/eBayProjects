#!perl -w

# loose end - throw exceptions on things not set

use XML::Parser;
use File::Basename;
use Data::Dumper;
my $returnmap =    {
			AddItem => 3,
			AddFixedPriceItem => 4,
		    ReviseItem => 3,
		    ReviseFixedPriceItem => 4,
		    RelistItem => 1,
		    RelistFixedPriceItem => 2,
		    GetItem => 5,
		    VerifyAddItem => 1,
		    VerifyAddFixedPriceItem => 2,
		    AddLiveAuctionItem => -1,
		    ReviseLiveAuctionItem => 1,
		    GetAccount => 3,
		    GetBidderList => 1,
		    GetCategoryFeatures => 2,
		    GetItemTransactions => 6,
		    GetNotificationPreferences => -1,
		    GetNotificationsUsage => -1,
		    GetOrders => 2,
		    GetPopularKeywords => 1,
		    GetProductSearchPage => 1,
		    GetProductFamilyMembers => 1,
		    GetProductSearchResults => 1,
		    GetReturnURL => 1,
		    GetSellerEvents => 1,
		    GetSellerList => 2,
		    GetSellerPayments => 2,
		    GetSellerTransactions => 7,
		    GetTaxTable => 1,
		    GetUserDisputes => 2,
		    GeteBayDetails => -1,
		    AddMemberMessage => -2,
            AddDisputeResponse => -2,
            AddOrder => -2,
            GetNotificationPreferences => -2,
            GetUserDisputes => -2,
            ReviseCheckoutStatus => -2,
            SellerReverseDispute => -2,
            SetNotificationPreferences => -2,
            VerifyAddSecondChanceItem => -2,
		    SetStoreCustomPage => -1,
		    AddToWatchList => -1,
		    GetAdFormatLeads => -1,
		    GetApiAccessRules => -1,
		    GetBestOffers => -1,
		    GetBidderList => -1,
		    GetCategoryFeatures => -1,
		    GetCategoryMappings => -1,
		    GetCharities => -1,
		    GetCrossPromotions => -1,
		    GetDescriptionTemplates => -1,
		    GetItemRecommendations => -1,
		    GetItemsAwaitingFeedback => -1,
		    GetLiveAuctionCatalogDetails => -1,
		    GetMyMessages => -1,
		    GetMyeBayBuying => -1,
		    GetMyeBayReminders => -1,
		    GetMyeBaySelling => -1,
		    GetPictureManagerDetails => -1,
		    GetPictureManagerOptions => -1,
		    GetPopularKeywords => -1,
		    GetPromotionRules => -1,
		    GetRecommendations => -1,
		    GetStore => -1,
		    GetStoreCustomPage => -1,
		    GetStoreOptions => -1,
		    GetStorePreferences => -1,
		    GetTaxTable => -1,
		    GetUserPreferences => -1,
		    LeaveFeedback => -1,
		    RemoveFromWatchList => -1,
		    RespondToBestOffer => -1,
		    GeteBayOfficialTime => ["java.util.Calendar", "resp == null? null: resp.getTimestamp()"], 
		    GetMyeBay => ["int", "this.totalItems()"],
};

  my $paramalias = { 
  			"ValidateTestUserRegistration.FeedbackScore" => FeedbackStore,
		     "AddToWatchList.ItemID" => ItemIDs,
		     "GetAttributesCS.AttributeSetID" => AttributeSetIDs,
		     "GetBidderList.GranularityLevel" => granularityLevel,
		     "GetCategoryFeatures.FeatureID" => FeatureIDs,
		     "GetCategories.CategoryParent" => ParentCategories,
		     "GetItemRecommendations.GetRecommendationsRequestContainer" => RecommendationsRequests,
		     "GetProductFinder.ProductFinderID" => ProductFinderIDs,
		     "GetProductSearchPage.AttributeSystemVersion" => LastAttributeVersion,
		     "GetProductSellingPages.Product" => Products,
		     "GetSearchResults.Order" => SortOrder,
		     "GetSellerEvents.NewItemFilter" => IncludeNewItem,
		     "RemoveFromWatchList.ItemID" => ItemIDs,
		     "RespondToBestOffer.BestOfferID" => BestOfferIDs,
		     "RespondToBestOffer.Action" => BestOfferAction,
		     "RelistItem.Item" => ItemToBeRelisted,
		     "RelistFixedPriceItem.Item" => ItemToBeRelisted,
		     "ReviseCheckoutStatus.OrderID" => OrderId,
		     "ReviseItem.Item" => ItemToBeRevised,
		     "ReviseFixedPriceItem.Item" => ItemToBeRevised,
		     "SetStore.Store" => StoreType,
		     "SetStoreCustomPage.CustomPage" => StoreCustomPage,
		     "GetSellerEvents.StartTimeFrom" => "StartTimeFilter",
		     "GetSellerEvents.StartTimeTo" => "",
		     "GetSellerEvents.EndTimeFrom" => "EndTimeFilter",
		     "GetSellerEvents.EndTimeTo" => "",
		     "GetSellerEvents.ModTimeFrom" => "ModTimeFilter",
		     "GetSellerEvents.ModTimeTo" => "",
		     "GetSellerList.StartTimeFrom" => "StartTimeFilter",
		     "GetSellerList.StartTimeTo" => "",
		     "GetSellerList.EndTimeFrom" => "EndTimeFilter",
		     "GetSellerList.EndTimeTo" => "",
		     "GetSellerTransactions.ModTimeFrom" => "ModifiedTimeFilter",
		     "GetSellerTransactions.ModTimeTo" => "",
		     "GetItemTransactions.ModTimeFrom" => "ModifiedTimeFilter",
		     "GetItemTransactions.ModTimeTo" => "",
		     "GetAccount.BeginDate" => "ViewPeriod",
		     "GetAccount.EndDate" => "",
		     "LeaveFeedback.ItemID" => "FeedbackDetail",
		     "LeaveFeedback.CommentText" => "",
		     "LeaveFeedback.CommentType" => "",
		     "GetAccount.AccountHistorySelection" => "ViewType",
		     "GetUserDisputes.ModTimeFrom" => "TimeFilter",
		     "GetUserDisputes.ModTimeTo" => "",
		     #"GetMyeBay.BiddingSort" => "ActiveSort",
		     #"GetRecommendations.ModifiedFields" => "ModifiedFieldType",
  };

  my $returnalias = { 
  			  "AddSecondChanceItem.returnedFees" => listingFees,
		      "GetAccount.returnedAccountID" => accountID,
		      "GetAccount.returnedAccountSummary" => accountSummary,
		      "GetAccount.returnedPaginationResult" => paginationResult,
		      "GetAccount.returnedHasMoreEntries" => hasMoreEntries,
		      "GetAccount.returnedAccountEntries" => accountEntries,
		      "GetAdFormatLeads.returnedAdFormatLead" => returnedAdFormatLeads,
		      "GetApiAccessRules.returnedApiAccessRule" => returnedApiAccessRules,
		      "GetAttributesCS.returnedAttributeData" => attributeData,
		      "GetAttributesCS.AttributeSystemVersion" => attributeSystemVersion,
		      "GetAttributesXSL.returnedXSLFile" => XSLFile,
		      "GetBestOffers.returnedBestOfferArray" => returnedBestOffers,
		      "GetCategories.returnedUpdateTime" => returnedCategoryUpdateTime,
		      "GetCategories.returnedMinimumReservePrice" => minimumReservePrice,
		      "GetCategories.returnedReservePriceInclusive" => reservePriceInclusive,
		      "GetCategory2CS.returnedMappedCategoryArray" => mappedCategories,
		      "GetCategory2CS.returnedUnmappedCategoryArray" => unmappedCategories,
		      "GetCategoryFeatures.returnedUpdateTime" => returnUpdateTime,
		      "GetCategoryListings.returnedPaginationResult" => paginationResult,
		      "GetCategoryListings.returnedItemArray" => returnedItems,
		      "GetCategoryListings.returnedHasMoreItems" => hasMoreItems,
		      "GetCategoryListings.returnedCategory" => returnedCategoryType,
		      "GetCharities.returnedCharity" => returnedCharities,
		      "GetFeedback.returnedFeedbackScore" => feedbackScore,
		      "GetFeedback.returnedFeedbackSummary" => feedbackSummary,
		      "GetFeedback.returnedFeedbackDetailArray" => returnedFeedbackDetails,
		      "GetFeedback.returnedFeedbackDetailItemTotal" => grandTotal,
		      "FetchToken.returnedEBayAuthToken" => returnedToken,
		      "FetchToken.returnedHardExpirationTime" => hardExpirationTime,
		      "GetHighBidders.returnedBidArray" => returnedOffers,
		      "GetItemRecommendations.returnedGetRecommendationsResponseContainer" => returnedRecommendations,
		      "GetItemTransactions.returnedPaginationResult" => paginationResult,
		      "GetItemTransactions.returnedHasMoreTransactions" => hasMoreTransactions,
		      "GetItemTransactions.returnedItem" => "item",
		      "GetItemTransactions.returnedPayPalPreferred" => payPalPreferred,
		      "GetItemTransactions.returnedReturnedTransactionCountActual" => returnedTransactionCountActual,
		      "GetItemTransactions.returnedTransactionArray" => returnedTransactions,
		      "GetMemberMessages.returnedMemberMessage" => returnedMemberMessages,
		      "GetMemberMessages.returnedPaginationResult" => paginationResult,
		      "GetMemberMessages.returnedHasMoreItems" => hasMoreItems,
		      "GetMyMessages.returnedMessages" => returnedMyMessages,
		      "GetMyeBay.returnedBiddingItemArray" => returnedBiddingList,
		      "GetMyeBay.returnedBiddingWatchItemArray" => returnedWatchItemList,
		      "GetMyeBay.returnedWonItemArray" => returnedWonItemList,
		      "GetMyeBay.returnedLostItemArray" => returnedLostItemList,
		      "GetMyeBay.returnedWatchItemArray" => returnedWatchList,
		      "GetNotificationPreferences.returnedUserData" => userData,
		      "GetNotificationPreferences.returnedEventProperty" => eventProperty,
		      "GetPopularKeywords.returnedCategoryArray" => returnedPopularKeywords,
		      "GetProductFamilyMembers.returnedProductSearchResult" => returnedProductSearchResults,
		      "GetProductFinder.returnedProductFinderData" => productFinderData,
		      "GetProductFinderXSL.returnedXSLFile" => xSLFile,
		      "GetProductSearchPage.returnedProductSearchPage" => returnedProductSearchPages,
		      "GetProductSellingPages.returnedProductSellingPagesData" => productSellingPagesData,
		      "GetPromotionRules.returnedPromotionRuleArray" => returnedPromotionRule,
		      "GetReturnURL.returnedAuthenticationEntryArray" => returnedAuthenticationEntries,
		      "GetReturnURL.returnedApplicationDisplayName" => applicationDisplayName,
		      "GetSearchResults.returnedPaginationResult" => resultPagination,
		      "GetSearchResults.returnedSearchResultItemArray" => returnedItems,
		      "GetSearchResults.returnedHasMoreItems" => hasMoreItems,
		      "GetSellerEvents.returnedItemArray" => returnedSellerEvents,
		      "GetSellerEvents.returnedTimeTo" => timeTo,
		      "GetSellerList.returnedPaginationResult" => paginationResult,
		      "GetSellerList.returnedHasMoreItems" => hasMoreItems,
		      "GetSellerList.returnedItemArray" => returnedItems,
		      "GetSellerList.returnedReturnedItemCountActual" => returnedItemCountActual,
		      "GetSellerTransactions.returnedPaginationResult" => paginationResult,
		      "GetSellerTransactions.returnedHasMoreTransactions" => hasMoreTransactions,
		      "GetSellerTransactions.returnedReturnedTransactionCountActual" => returnedTransactionCountActual,
		      "GetSellerTransactions.returnedTransactionArray" => returnedTransactions,
		      "GetSellerTransactions.returnedPayPalPreferred" => payPalPreferred,
		      "GetSellerTransactions.returnedSeller" => 'seller',
		      "GetSellerList.returnedSeller" => 'seller',
		      "GetStoreOptions.returnedMaxCategories" => maxCategories,
		      "GetStoreOptions.returnedMaxCategoryLevels" => maxCategoryLevels,
		      "GetStorePreferences.returnedStorePreferences" => returnedStorePreferencesType,
		      "RelistItem.returnedFees" => listingFees,
		      "RelistFixedPriceItem.returnedFees" => listingFees,
		      "RespondToBestOffer.returnedRespondToBestOffer" => returnedBestOffers,
		      "ReviseItem.returnedFees" => listingFees,
		      "ReviseFixedPriceItem.returnedFees" => listingFees,
		      "SetStoreCustomPage.returnedCustomPage" => returnedStoreCustomPageType,
		      "GetStore.returnedStore" => returnedStoreType,
		      "GetStoreCustomPage.returnedCustomPageArray" => returnedStoreCustomPageArrayType,
		      #"GetItemsAwaitingFeedback.returnedItemsAwaitingFeedback" => returnedTransaction,
  };

  my $wrapperType = {
  	               "DisableUnpaidItemAssistance.ItemID" => ["String", ""], # ItemIDType
  	               "DisableUnpaidItemAssistance.DisputeID" => ["String", ""], # DisputeIDType
  	               "VerifyRelistItem.ReturnedItemID" => ["String", ""], #ItemIDType
  	               "AddDispute.ItemID" => ["String", ""], # ItemIDType
  	               "AddDispute.ReturnedDisputeID" => ["String", ""], # DisputeIDType
  	               "AddDisputeResponse.DisputeID" => ["String", ""], # DisputeIDType
  	               "AddItem.ReturnedItemID" => ["String", ""], # ItemIDType
  	               "AddItemFromSellingManagerTemplate.ReturnedItemID" => ["String", ""], # ItemIDType
  	               "AddLiveAuctionItem.ReturnedItemID" => ["String", ""], # ItemIDType
  	               "AddMemberMessageAAQToPartner.ItemID" => ["String", ""], # ItemIDType
  	               "AddMemberMessageRTQ.ItemID" => ["String", ""], # ItemIDType
  	               "DeleteSellingManagerItemAutomationRule.ItemID" => ["String", ""], # ItemIDType
  	               "SendInvoice.OrderID" => ["String", ""], #OrderIDType
  	               "SendInvoice.ItemID" => ["String", ""], # ItemIDType
  	               "AddOrder.ReturnedOrderID" => ["String", ""], #OrderIDType
  	               "AddSecondChanceItem.RecipientBidderUserID" => ["String", ""], #UserIDType
  	               "AddSecondChanceItem.ItemID" => ["String", ""], # ItemIDType
  	               "AddSecondChanceItem.ReturnedItemID" => ["String", ""], # ItemIDType
  	               "AddToItemDescription.ItemID" => ["String", ""], # ItemIDType
  	               "AddTransactionConfirmationItem.RecipientUserID" => ["String", ""], #UserIDType
  	               "AddTransactionConfirmationItem.RecipientRelationType" => ["String", ""], #RecipientRelationCodeType
  	               "AddTransactionConfirmationItem.ItemID" => ["String", ""], #ItemIDType
  	               "AddTransactionConfirmationItem.ReturnedItemID" => ["String", ""], # ItemIDType
  	               "GetAdFormatLeads.ItemID" => ["String", ""], #ItemIDType
  	               "GetAllBidders.ItemID" => ["String", ""], #ItemIDType
  	               "GetFeedback.ItemID" => ["String", ""], #ItemIDType
  	               "GetAllBidders.ReturnedHighBidder" => ["String", ""], #UserIDType
  	               "GetBidderList.UserID" => ["String", ""], #UserIDType  	            
  	               "GetSellingManagerEmailLog.ItemID" => ["String", ""], # ItemIDType
  	               "GetSellingManagerEmailLog.OrderID" => ["String", ""],# OrderIDType
  	               "GetSellingManagerItemAutomationRule.ItemID" => ["String", ""], # ItemIDType
  	               "GetSellingManagerSaleRecord.ItemID" => ["String", ""], # ItemIDType
  	               "GetSellingManagerSaleRecord.OrderID" => ["String", ""],# OrderIDType
  	               "ReviseSellingManagerSaleRecord.ItemID" => ["String", ""], # ItemIDType
  	               "ReviseSellingManagerSaleRecord.OrderID" => ["String", ""],# OrderIDType
  	               "SaveItemToSellingManagerTemplate.ItemID" => ["String", ""], # ItemIDType
  	               "GetSellingManagerTemplates.SaleTemplateID" => ["long[]",""], # Long
  	               "SendInvoice.SKU" => ["String", ""], # SKUType
  	               "SetSellingManagerItemAutomationRule.ItemID" => ["String", ""], # ItemIDType
		       "CompleteSale.ItemID" => ["String", ""], # ItemIDType
		       "EndItem.ItemID" => ["String", ""], #ItemIDType
		       "GetAccount.ItemID" => ["String", ""], # ItemIDType
		       "GetBestOffers.ItemID" => ["String", ""], # ItemIDType
		       "GetBestOffers.BestOfferID" => ["String", ""], # BestOfferIDType
		       "GetCategories.LevelLimit" => "int", # Integer
		       "GetCrossPromotions.ItemID" => ["String", ""], # ItemIDType
		       "GetDispute.DisputeID" => ["String", ""], # DisputeIDType
		       "GetFeedback.UserID" => ["String", ""], #UserIDType
		       "GetSearchResultsExpress.SellerID" => ["String", ""], #UserIDType
		       "GetSellerEvents.UserID" => ["String", ""], #UserIDType
		       "LeaveFeedback.TargetUser" => ["String", ""], #UserIDType
		       "GetSellerList.UserID" => ["String", ""], #UserIDType
		       "GetHighBidders.ItemID" => ["String", ""], # ItemIDType
		       "PlaceOffer.ItemID" => ["String", ""], # ItemIDType
		       "RelistItem.ReturnedItemID" => ["String", ""], # ItemIDType
		       "GetVeROReportStatus.ItemID" => ["String", ""], # ItemIDType
		       "IssueRefund.ItemID" => ["String", ""], # ItemIDType
		       "GetWantItNowPost.PostID" => ["String", ""], # ItemIDType
		       "GetItem.ItemID" => ["String", ""], # ItemIDType
		       "GetItem.SKU" => ["String", ""], # SKUType
		       "GetItemShipping.ItemID" => ["String", ""], # ItemIDType
		       "GetItemTransactions.ItemID" => ["String", ""], # ItemIDType
		       "GetMyeBay.MaxItemsPerList" => "int", # Integer
		       "GetMyeBay.MaxItemAgeInDays" => "int", # Integer
		       "GetPromotionRules.ItemID" => ["String", ""], # ItemIDType
		       "GetNotificationsUsage.ItemID" => ["String", ""], # ItemIDType
		       "GetSellerEvents.IncludeNewItem" => "boolean", # Boolean
		       "GetSellerList.Sort" => "int", # Integer
		       "RespondToBestOffer.ItemID" => ["String", ""], # ItemIDType
		       "RespondToFeedback.ItemID" => ["String", ""], # ItemIDType
		       "RespondToWantItNowPost.ItemID" => ["String", ""], # ItemIDType
		       "RespondToWantItNowPost.PostID" => ["String", ""], # ItemIDType
		       "ReviseCheckoutStatus.ItemID" => ["String", ""], # ItemIDType
		       "VerifyAddItem.ReturnedItemID" => ["String", ""], # ItemIDType
		       "ReviseLiveAuctionItem.ReturnedItemID" => ["String", ""], # ItemIDType
		       "ReviseItem.ReturnedItemID" => ["String", ""], # ItemIDType
		       "RespondToFeedback.TargetUserID" => ["String", ""], # UserIDType
		       "VerifyAddSecondChanceItem.ItemID" => ["String", ""], # ItemIDType
		       "VerifyAddSecondChanceItem.RecipientBidderUserID" => ["String", ""], # UserIDType
		       "VeROReportItems.RightsOwnerID" => ["String", ""], # UserIDType
		       "GetStore.UserID" => ["String", ""], # UserIDType
		       "GetUser.ItemID" => ["String", ""], # ItemIDType
		       "SetUserNotes.ItemID" => ["String", ""], # ItemIDType
		       "SetUserNotes.SKU" => ["String", ""], # SKUType
  	               "GetUserDisputes.ReturnedStartingDisputeID" => ["String", ""], # DisputeIDType
  	               "GetUserDisputes.ReturnedEndingDisputeID" => ["String", ""], # DisputeIDType
  	               "SellerReverseDispute.DisputeID" => ["String", ""], # DisputeIDType
		       "GetMemberMessages.SenderID" => ["String", ""], # UserIDType
		       "GetMemberMessages.ItemID" => ["String", ""], # ItemIDType
		       "GetMessagePreferences.SellerID" => ["String", ""], # UserIDType
		       "AddFixedPriceItem.ReturnedItemID" => ["String", ""], #ItemIDType
		       "AddFixedPriceItem.ReturnedSKU" => ["String", ""], #SKUType
		       "EndFixedPriceItem.ItemID" => ["String", ""], #ItemIDType
		       "EndFixedPriceItem.SKU" => ["String", ""], #SKUType
		       "EndFixedPriceItem.ReturnedSKU" => ["String", ""], #SKUType
		       "GetItem.VariationSKU" => ["String", ""], #SKUType
		       "RelistFixedPriceItem.ReturnedItemID" => ["String", ""], #ItemIDType
		       "RelistFixedPriceItem.ReturnedSKU" => ["String", ""], #SKUType
		       "ReviseFixedPriceItem.ReturnedItemID" => ["String", ""], #ItemIDType
		       "ReviseFixedPriceItem.ReturnedSKU" => ["String", ""], #SKUType
		       "VerifyAddFixedPriceItem.ReturnedItemID" => ["String", ""], #ItemIDType
		       "VerifyAddFixedPriceItem.ReturnedSKU" => ["String", ""], #SKUType
    		   "AddSecondChanceItem.CopyEmailToSeller" => ["boolean", ""], # Boolean
    		   "VerifyAddSecondChanceItem.CopyEmailToSeller" => ["boolean", ""], # Boolean
		       "AddToWatchList.ItemIDs" => ["String[]", ""],
		       "RemoveFromWatchList.ItemIDs" => ["String[]", ""],
		       "RespondToBestOffer.BestOfferIDs" => ["String[]", ""],
		       "GetMyMessages.AlertIDs" => ["String[]", "MyMessagesAlertIDArrayType", "AlertID"],
		       "GetMyMessages.MessageIDs" => ["String[]", "MyMessagesMessageIDArrayType", "MessageID"],
		       "DeleteMyMessages.AlertIDs" => ["String[]", "MyMessagesAlertIDArrayType", "AlertID"],
		       "DeleteMyMessages.MessageIDs" => ["String[]", "MyMessagesMessageIDArrayType", "MessageID"],
		       "ReviseMyMessages.AlertIDs" => ["String[]", "MyMessagesAlertIDArrayType", "AlertID"],
		       "ReviseMyMessages.MessageIDs" => ["String[]", "MyMessagesMessageIDArrayType", "MessageID"],

		       "AddToWatchList.ReturnedWatchListCount" => "int",
		       "AddToWatchList.ReturnedWatchListMaximum" => "int",
		       "GetDescriptionTemplates.ReturnedLayoutTotal" => "int",
		       "GetDescriptionTemplates.ReturnedThemeTotal" => "int",
		       "GetFeedback.GrandTotal" => "int",
		       "GetFeedback.FeedbackScore" => "int",
		       "GetItemTransactions.ReturnedTransactionCountActual" => "int",
		       "GetSellerList.ReturnedItemCountActual" => "int",
		       "GetSellerTransactions.ReturnedTransactionCountActual" => "int",
		       "RemoveFromWatchList.ReturnedWatchListCount" => "int",
		       "RemoveFromWatchList.ReturnedWatchListMaximum" => "int",

		       "GetAccount.HasMoreEntries" => "boolean",
		       "GetCategoryListings.HasMoreItems" => ["boolean", ""],
		       "GetItemTransactions.HasMoreTransactions" => "boolean",
		       "GetItemTransactions.PayPalPreferred" => "boolean",
		       "GetSellerList.HasMoreItems" => "boolean",
		       "GetSellerTransactions.HasMoreTransactions" => "boolean",
		       "GetSellerTransactions.PayPalPreferred" => "boolean",
		       "GetMyMessages.FolderID" => "long",
		       "GetStoreCategoryUpdateStatus.TaskID" => "long",
		       
		       "GetBestOffers.ReturnedBestOffers" => ["BestOfferType[]", "getBestOffer"],
		       "GetBidderList.ReturnedBidItemArray" => ["ItemType[]", "getItem"],
		       "GetCategories.CategorySiteID" => ["SiteCodeType", "stringFromSiteCodeType"],
		       "GetCategory2CS.MappedCategories" => ["CategoryType[]", "getCategory"],
		       "GetCategory2CS.UnmappedCategories" => ["CategoryType[]", "getCategory"],
		       "GetCategoryListings.ReturnedItems" => ["ItemType[]", "getItem"],
		       "GetCategoryListings.ReturnedSubCategories" => ["CategoryType[]", "getCategory"],
		       "GetAttributesCS.AttributeSetIDs" => ["int[]", ""],
		       "GetProductSearchPage.AttributeSetID" => ["int[]", ""],
		       "ReviseMyMessagesFolders.FolderID" => ["long[]", ""],
		       "GetDescriptionTemplates.ReturnedObsoleteLayoutID" => ["int[]", ""],
		       "GetDescriptionTemplates.ReturnedObsoleteThemeID" => ["int[]", ""],
		       "GetProductFinder.ProductFinderIDs" => ["int[]", ""],
		       "GetFeedback.ReturnedFeedbackDetails" => ["FeedbackDetailType[]", "getFeedbackDetail"],
		       "GetHighBidders.ReturnedOffers" => ["OfferType[]", "getOffer"],
		       "GetItemTransactions.ReturnedTransactions" => ["TransactionType[]", "getTransaction"],
		       "GetMemberMessages.ReturnedMemberMessages" => ["MemberMessageExchangeType[]", "getMemberMessageExchange"],
		       "GetMyMessages.ReturnedAlerts" => ["MyMessagesAlertType[]", "getAlert"],
		       "GetMyMessages.ReturnedMyMessages" => ["MyMessagesMessageType[]", "getMessage"],
		       "GetMyeBay.ReturnedBiddingList" => ["ItemType[]", "getItem"],
		       "GetMyeBay.ReturnedLostItemList" => ["ItemType[]", "getItem"],
		       "GetMyeBay.ReturnedWatchList" => ["ItemType[]", "getItem"],
		       "GetMyeBay.ReturnedWonItemList" => ["ItemType[]", "getItem"],
		       "GetPopularKeywords.ReturnedPopularKeywords" => ["CategoryType[]", "getCategory"],
		       "GetPromotionRules.ReturnedPromotionRule" => ["PromotionRuleType[]", "getPromotionRule"],
		       "GetRecommendations.ReturnedListingAnalyzerRecommendations" => ["ListingTipType[]", "getListingTipArray().getListingTip"],
		       "GetRecommendations.ReturnedPricingRecommendations" => ["ProductInfoType", "getProductInfo"],
		       "GetRecommendations.ReturnedAttributeRecommendations" => ["AttributeSetType[]", "getAttributeSetArray().getAttributeSet"],
		       "GetRecommendations.ReturnedProductRecommendations" => ["ProductInfoType[]", "getProduct"],
		       "GetReturnURL.ReturnedAuthenticationEntries" => ["AuthenticationEntryType[]", "getAuthenticationEntry"],
		       "GetSearchResults.ReturnedItems" => ["SearchResultItemType[]", "getSearchResultItem"],
		       "GetSearchResults.HasMoreItems" => ["boolean", ""],
		       "GetSearchResultsExpress.ReturnedHasMoreEntries" => ["boolean", ""],
		       "GetSellerEvents.ReturnedSellerEvents" => ["ItemType[]", "getItem"],
		       "GetSellerList.ReturnedItems" => ["ItemType[]", "getItem"],
		       "GetSellerTransactions.ReturnedTransactions" => ["TransactionType[]", "getTransaction"],
		       "RespondToBestOffer.ReturnedBestOffers" => ["BestOfferType[]", "getBestOffer"],
		       "SetStoreCategories.ReturnedTaskID" => "long",
		       "GetSuggestedCategories.ReturnedSuggestedCategoryArray" => ["SuggestedCategoryType[]", "getSuggestedCategory"],
		       "GetCategories.ReturnedCategoryArray" => ["CategoryType[]", "getCategory"],
		       "GetAllBidders.ReturnedBidArray" => ["OfferType[]", "getOffer"],
		       "GetAccount.AccountEntries" => ["AccountEntryType[]", "getAccountEntry"],
		       "GetOrders.ReturnedOrderArray" => ["OrderType[]", "getOrder"], 
		       #"GetItemsAwaitingFeedback.ReturnedTransaction" => ["TransactionType[]", "getTransaction"], 
		       "GetSellerEvents.StartTimeFilter" => ["TimeFilter", {"StartTimeFrom" => "TimeFrom", "StartTimeTo" => "TimeTo"}],
		       "GetSellerEvents.EndTimeFilter" => ["TimeFilter", {"EndTimeFrom" => "TimeFrom", "EndTimeTo" => "TimeTo"}],
		       "GetSellerEvents.ModTimeFilter" => ["TimeFilter", {"ModTimeFrom" => "TimeFrom", "ModTimeTo" => "TimeTo"}],
		       "GetSellerList.StartTimeFilter" => ["TimeFilter", {"StartTimeFrom" => "TimeFrom", "StartTimeTo" => "TimeTo"}],
		       "GetSellerList.EndTimeFilter" => ["TimeFilter", {"EndTimeFrom" => "TimeFrom", "EndTimeTo" => "TimeTo"}],
		       "GetSellerTransactions.ModifiedTimeFilter" => ["TimeFilter", {"ModTimeFrom" => "TimeFrom", "ModTimeTo" => "TimeTo"}],
		       "GetItemTransactions.ModifiedTimeFilter" => ["TimeFilter", {"ModTimeFrom" => "TimeFrom", "ModTimeTo" => "TimeTo"}],
		       "GetUserDisputes.TimeFilter" => ["TimeFilter", {"ModTimeFrom" => "TimeFrom", "ModTimeTo" => "TimeTo"}],
		       "GetAccount.ViewPeriod" => ["TimeFilter", {"BeginDate" => "TimeFrom", "EndDate" => "TimeTo"}],
		       "LeaveFeedback.FeedbackDetail" => ["FeedbackDetailType", {"ItemID" => "ItemID", "CommentText" => "CommentText", "CommentType" => "CommentType"}],
		       "SetUserPreferences.EBxOptInPreference" => ["EBxOptInPreferenceType", ""],
  		       "GetUserPreferences.ShowBidderNoticePreferences" => ["Boolean", "booleanValue"],
  		       "GetUserPreferences.ShowCombinedPaymentPreferences" => ["Boolean", "booleanValue"],
  		       "GetUserPreferences.ShowCrossPromotionPreferences" => ["Boolean", "booleanValue"],
  		       "GetUserPreferences.ShowSellerPaymentPreferences" => ["Boolean", "booleanValue"],
		       "GetUserPreferences.ReturnedEBxOptInPreference" => ["EBxOptInPreferenceType", ""],
};

  my $paramdefaults = { "GetAccount.viewType" => "AccountHistorySelectionCodeType.LAST_INVOICE",
			"GetCategories.categorySiteID" => "SiteCodeType.US",
		      };

  my $extrareturn = { "GeteBayDetails" => "ReturnedeBayDetails",
		      "GetMyeBayBuying" => "ReturnedGetMyeBayBuyingResponse",
		      "GetMyeBaySelling" => "ReturnedMyeBaySellingResponse",
		      };

  my $requestoverride = { "GetMyeBayBuying" => "MyeBayBuyingRequest",
			  "GetMyeBaySelling" => "MyeBaySellingRequest",
			  "GetSearchResults" => "OverrideGetSearchResultsRequest",
			  "SendInvoice" => "SendInvoiceRequest",
			  "GetCharities" => "OverrideRequest",
			  "GetSellerList" => "Request",
		        };

  my $exceptionifnull = { 
			  # " AddItem throw new SdkException(sb.toString());
			  # special logic - AddSecondChanceItem, listing duration
			  "AddLiveAuctionItem" => ["Item"],
			  # AddMemberMessage.initialexec.txt
			  # AddSecondChanceItem.initialexec.txt
			  "AddToItemDescription" => ["ItemID", "Description"],
			  # AddToWatchList.initialexec.txt
			  # "CompleteSale" => ["ItemID"], #fix BUGDB00652523 
			  # EndItem.initialexec.txt
			  # "FetchToken" => ["SessionID"],
			  # GetAccount.initialexec.txt
			  "GetAdFormatLeads" => ["ItemID"],
			 #Removed in 805 bug(EBAYSDK-2) "GetBestOffers" => ["ItemID"],
			  "GetCategoryListings" => ["CategoryID"],
			  "GetCrossPromotions" => ["ItemID", "PromotionMethod"],
			  "GetFeedback" => ["UserID"],
			  "GetHighBidders" => ["ItemID"],
			  "GetItemRecommendations" => ["RecommendationsRequests"],
			 #Removed in 917 EBAYSDK-46 "GetItemTransactions" => ["ItemID", "ModifiedTimeFilter"],
			 "GetItemTransactions" => ["ItemID"],
			  "GetProductFamilyMembers" => ["ProductSearch"],
			  "GetProductSearchPage" => ["AttributeSetID"],
			  "GetProductSellingPages" => ["Products", "UseCase"],
			  "GetPromotionRules" => ["PromotionMethod"],
			  "GetSellerTransactions" => ["ModifiedTimeFilter"],
			  "LeaveFeedback" => ["TargetUser", "FeedbackDetail", "FeedbackDetail.getItemID()", "FeedbackDetail.getCommentText()", "FeedbackDetail.getCommentType()"],
			  # RelistItem.initialexec.txt
			  # RespondToBestOffer.initialexec.txt
			  "RespondToFeedback" => ["TargetUserID", "ResponseType", "ResponseText"],
			  # ReviseItem.initialexec.txt
			  "ReviseMyMessagesFolders" => ["FolderID", "Operation"],
			  "SendInvoice" => ["SendInvoiceRequest"],
			  "SetPictureManagerDetails" => ["Action", "PictureManagerDetails"],
			  "SetReturnURL" => ["AuthenticationEntry", "Action"],
			  "SetStore" => ["StoreType"],
			  "SetStoreCustomPage" => ["StoreCustomPage"],
			  "SetStorePreferences" => ["StorePreferences"],
			  "SetTaxTable" => ["TaxTable"],
			  "SetUserNotes" => ["ItemID", "Action"],
			};

  my $detaillevellist = { 

			  "GetAccount" => 1,
			  "GetAdFormatLeads" => 1,
			  "GetAllBidders" => 1,
			  "GetAttributesCS" => 1,
			  "GetAttributesXSL" => 1,
			  "GetBestOffers" => 1,
			  "GetBidderList" => 1,
			  "GetCategories" => 1,
			  "GetCategory2CS" => 1,
			  "GetCategoryFeatures" => 1,
			  "GetCategoryListings" => 1,
			  "GetCategoryMappings" => 1,
			  "GetCouponValidation" => 1,
			  "GetDispute" => 1,
			  "GetFeedback" => 1,
			  "GetHighBidders" => 1,
			  "GetItemTransactions" => 1,
			  "GetItem" => 1,
			  "GetItemShipping" => 1,
			  "GetNotificationPreferences" => 1,
			  "GetOrders" => 1,
			  "GetPictureManagerDetails" => 1,
			  "GetProductFamilyMembers" => 1,
			  "GetProductFinder" => 1,
			  "GetProductFinderXSL" => 1,
			  "GetProductSearchPage" => 1,
			  "GetProductSearchResults" => 1,
			  "GetSearchResultsExpress" => 1,
			  "GetSearchResults" => 1,
			  "GetSellerEvents" => 1,
			  "GetSellerList" => 1,
			  "GetSellerTransactions" => 1,
			  "GetSuggestedCategories" => 1,
			  "GetTaxTable" => 1,
			  "GetUserDisputes" => 1,
			  "GetUser" => 1,
			  "GeteBayDetails" => 1,
			  "LeaveFeedback" => 1,
			  "ValidateTestUserRegistration" => 1,
			};
# Deprecated calls list reverted 10/16/2012 for reopening JIRA SDK-406
my $deprecatedCalls = { "GetMyeBayCall" => 1, };
#nonSOAPCalls added by william, 3/30/2008
my $nonSOAPCalls = { "UploadSiteHostedPicturesCall" => 1,
                   };
my $currentObject;
my $types;
my $requests;
my $current_text = "";
my $currentType = undef;
my $doc;
my $collect_text = 0;
my $simpletypeassign = 0;
my $redefs;
my %oldfunctions;

sub handle_start {
    my( $expat, $element, %attrs ) = @_;

    # ask the expat object about our position
    my $line = $expat->current_line;
    my $name = $attrs{name};
    $current_text = undef;

    if ($element eq 'xs:complexType') {
      $currentObject = $name;
      $currentType = $name;
      #BotBlockRequestType addeb by william, 3/30/2008
      if ($name =~ /RequestType$/ && $name !~ /AbstractRequestType|SearchRequestType|BotBlockRequestType/) {
        my $request = $name;
        $request =~ s/RequestType//;
        $requests->{$request} = $request;
      }
      $types->{$name}->{name} = $name;
    }

    if ($element eq 'xs:simpleType' && $name !~ /CodeType$/) {
      $currentObject = $name;
      $simpletypeassign = 1;
    }
    
    if ($element eq 'xs:restriction' && $simpletypeassign) {
      my $type = $attrs{base};
      $redefs->{$currentObject} = $type;
    }

    if ($element eq 'xs:element') {
#print "Found element: $name for type: $currentType \n";
      my $type = $attrs{type};
      if (defined($currentType)) {
         $currentObject = $currentType . "." .$name;
      }

      my $max = $attrs{maxOccurs} || "";
      my $min = $attrs{minOccurs};

      my $elementrec;
      $elementrec->{name} = $name;
      $elementrec->{type} = $type;
      $elementrec->{max} = $max;
      $elementrec->{paramobjname} = $currentObject;

      if (defined($currentType)) {
	if (!defined($min) || $min ne "0") {
#	  print "$currentType.$name $type\n";
	}

        my $children = $types->{$currentType}->{children};
        push(@{$children}, $elementrec);
#        print "Type: $currentType: Children: " . $children->[0]->{name} . "\n";
        $types->{$currentType}->{children} = $children;
      } else {
	if ($type !~ /ResponseType$/ && $type !~ /RequestType$/) {
          print "Orphan element: $name at line: $line \n";
	}
      }
    }

    if ($element eq 'xs:documentation') {
      $collect_text = 1;
    }
}

sub handle_end {
    my( $expat, $element ) = @_;
    if ($element =~ /xs:complexType/) {
      $currentType = undef;
      $currentObject = undef;
    }
    if ($element =~ /xs:element/) {
      $currentObject = undef;
    }
    if ($element =~ /xs:documentation/) {
      if (defined($currentObject) && defined ($current_text) && $current_text !~ /^\s*$/) {
        $doc->{$currentObject} = $current_text;
# print "x add doc for $currentObject: $current_text \n";
      }
      $current_text = "";
      $collect_text = 0;
    }
    if ($element =~ /xs:simpleType/) {
      $currentObject = undef;
      $simpletypeassign = 0;
    }

}

sub handle_char {
    my ($expat, $string) = @_;
# print "X $collect_text $string \n";
    $current_text .= $string if ($collect_text);
}


my $parser = XML::Parser->new( Handlers => 
                                     {
                                      Start=>\&handle_start,
				      Char =>\&handle_char,
                                      End=>\&handle_end,
                                     });

my $file = shift @ARGV;

if (!defined($file)) {
  print "Usage: " . basename($0) . " <filename>";
  exit -1;
}

if ( ! -d "JavaCall" ) {
    mkdir "JavaCall" or die "Can't create directory 'JavaCall'";
}

$parser->parsefile($file);

if( $@ ) {
    $@ =~ s/at \/.*?$//s;               # remove module line number
    print STDERR "\nERROR in '$file':\n$@\n";
}

my $template = slurp("java.template.txt");

my $gettemplate = slurp("get.template.txt");
my $settemplate = slurp("set.template.txt");
my $returntemplate = slurp("return.template.txt");

my $paramlangmap = {'xs:string' => 'java.lang.String',
		    'xs:boolean' => 'java.lang.Boolean',
		    'xs:int' => 'java.lang.Integer',
		    'xs:double' => 'java.lang.Double',
		    'xs:dateTime' => 'java.util.Calendar',
		    'xs:date' => 'java.util.Calendar',
		    'xs:long' => 'java.lang.Long',
		    'xs:token' => 'java.lang.String',
		    'xs:anyURI' => 'java.lang.String',
};

foreach my $k (sort keys %{$requests}) {
  if (defined (my $ref1 = $deprecatedCalls->{"${k}Call"})) {
  	next;
  }
  if (defined (my $ref2 = $nonSOAPCalls->{"${k}Call"})) {
  	next;
  }
  my $outfile = ">JavaCall/${k}Call.java";
  open(OUTF, $outfile) or die "Can't open file: $outfile";
  my $callname = $k;
  my $l_callname = $callname;
  $l_callname =~ s/(.)/\L$1/;
  my $calltype = $k . "RequestType";
  my $responsetype = $k . "ResponseType";
  my $calldoc = $doc->{$calltype};
    if (! $calldoc) {
      print "Missing doc for $calltype \n";
      $calldoc = "";
    }

  $calldoc =~ s/^\s*/   * /gm;

  my $allfunctions = "";
  my $paramsdoc = " * ";
  my $paraminit = "";
  my $privatemember="";
  my $sortoutput;

  my $callrec = $types->{$calltype};
  my $children = $callrec->{children};

  my %imports;

#  scanOldWrappers($callname);

  if ($detaillevellist->{$callname}) {
    $paraminit .= "    req.setDetailLevel(this.getDetailLevel());\n";
  }

  foreach my $i (0..$#$children) {
    my $element = $children->[$i];
    my $paramname = $element->{name} || 'noname';
    $paramname =~ s/(.)/\U$1/;
    my $paramtype = $element->{type} || 'notype';
    my $paramobjname = $element->{paramobjname};
    my $origparamname = $paramname;

    my $timetoparamname;
    if (defined(my $rename = $paramalias->{"$callname.$paramname"})) {
      $origparamname = $paramname;
      $paramname = $rename;
      # Special code for time filter.  Process the "From" entry on behalf of both From/To.
      # Just continue for the "To" entry.
      next if ($paramname eq "");
    }

    my $u_paramname = $paramname;
    $paramname =~ s/(.)/\L$1/;
    my $constructcode = "this.$paramname";
    my $paramlangtype = getlanguagetype($paramtype, $element->{max}, \%imports);
    my $realparamtype = $paramlangtype;

    my $overrideParamInit = 0;

    my $defvalue = "null";
    if (defined(my $ref = $wrapperType->{"$callname.$u_paramname"})) {
      if (ref($ref) eq "ARRAY") {
	my $constructfn;
	($paramlangtype, $constructfn, $innername) = @$ref;
	$defvalue = "0" if ($paramlangtype eq "int" || $paramlangtype eq "long");
	$defvalue = "false" if ($paramlangtype eq "boolean");
	if (defined($innername)) {
	  # Special case - must create a block, construct the wrapper type, and set inner type into it.
	  $paraminit .= "    if (this.$paramname != null)\n    {\n      $constructfn ary = new $constructfn();\n      ary.set$innername(this.$paramname);\n      req.set$origparamname(ary);\n    }\n";
	  $overrideParamInit = 1;
	} else {
	    # Used for the input containers TimeFilter, FeedbackDetail - the 2nd element in list is 
	    # itself a list.  Instead of being the constructor function, this lists the members to be 
	    # set from within the container.
	  if (ref($constructfn) eq "HASH") {
	    $paraminit .= "    if (this.$paramname != null)\n    {";
	    my @originnerparams = sort keys %$constructfn;
	    my $newdoc = "Helper wrapper to set $calltype " . join (", ", @originnerparams) . ":\n";
	    foreach my $originnerparam(@originnerparams) {
	      my $innerparam = $constructfn->{$originnerparam};
	      $paraminit .= "\n      req.set$originnerparam(this.$paramname.get$innerparam());";
	      my $paramobj = "${calltype}.$originnerparam";
	      $newdoc .= "\n$innerparam sets $paramobj: " . $doc->{$paramobj};
            }
	    $paraminit .= "\n    }\n";
	    my $timetoobjname = $paramobjname;
	    $timetoobjname=~ s/^Begin/End/;
	    $doc->{$paramobjname} = $newdoc;
#	    $doc->{$paramobjname} = "Time range helper value for $origparamname and $timetoparamname.\n   " . "$origparamname: " . $doc->{$paramobjname} . "$timetoparamname: " . $doc->{$timetoobjname};
	    $overrideParamInit = 1;
	  } elsif ($constructfn =~ /booleanValue$/) {
	    $constructcode = "this.$paramname.booleanValue()";
	  } elsif ($constructfn eq "") {
	    $constructcode = "this.$paramname";
	  } else {
	    $constructcode = "$constructfn(this.$paramname)";
	  }
	}
      } else {
	$paramlangtype = $ref;
	if ($paramlangtype eq "TimeFilter") {
	  $paraminit .= "    if (this.$paramname != null)\n    {\n      req.set$origparamname(this.$paramname.getTimeFrom());\n      req.set$timetoparamname(this.$paramname.getTimeTo());\n    }\n";
	  $overrideParamInit = 1;
	} else {
	  $defvalue = "0" if ($paramlangtype eq "int" || $paramlangtype eq "long");
	  $defvalue = "false" if ($paramlangtype eq "boolean");
	  $constructcode = "new $realparamtype(this.$paramname)";
	}
      }
    }

    if (!$overrideParamInit) {
      my $setcode = "req.set$origparamname($constructcode);";
      $paraminit .= "    if (this.$paramname != $defvalue)\n      $setcode\n";
    }

    my $getout = getreturnlogic($gettemplate, $callname, $u_paramname, $paramname, $paramlangtype);
    my $setout = getreturnlogic($settemplate, $callname, $u_paramname, $paramname, $paramlangtype);

    $allfunctions .= "${getout}${setout}";

    my $paramdoc = $doc->{$paramobjname};
    if (! $paramdoc) {
      print "Missing doc for $paramobjname \n";
      $paramdoc = "";
    }
    $paramdoc =~ s/^\s*//m;
    $paramdoc =~ s/^\s+/ * /gm;
    my $paramdocout = "<br> <B>Input property:</B> <code>$u_paramname</code> - $paramdoc";

    $paramsdoc .= $paramdocout;

    my $paramdefault = $paramdefaults->{"$callname.$paramname"} || $defvalue;
    $privatemember .= "  private $paramlangtype $paramname = $paramdefault;\n";

    # Check against original - $callname, $u_paramname, $paramlangtype
    my $record = $oldfunctions{"$callname.get$u_paramname."};
    if (defined($record)) {
      if ($record->{returntype} eq $paramlangtype) {
	#print "Match: $callname.get$u_paramname.$paramlangtype\n";
      } else {
	print "  1. Match but wrong type $record->{returntype} / $paramlangtype: $callname.get$u_paramname\n";
	#print "Z		       \"$callname.$u_paramname\" => \"$record->{returntype}\", # $paramlangtype\n";
      }
      $record->{match} = 1;
      my $order = sprintf("%05d", $record->{order});
      $sortoutput->{$order} = $getout;
    } else {
      $sortoutput->{"$u_paramname.get"} = $getout;
      #print "    Extra: $callname.get$u_paramname.\n";
    }
    $record = $oldfunctions{"$callname.set$u_paramname.$paramlangtype"};
    if (defined($record)) {
      #print "Match: $callname.set$u_paramname.$paramlangtype\n";
      $record->{match} = 1;
      my $order = sprintf("%05d", $record->{order});
      $sortoutput->{$order} = $setout;
    } else {
      $sortoutput->{"$u_paramname.set.$paramlangtype"} = $setout;
      #print "    Extra: $callname.set$u_paramname.$paramlangtype\n";
    }
    # end check

  }

  my $paramcheck = slurp("javamap/$callname.initialexec.txt");
  if (defined(my $checkparams = $exceptionifnull->{$callname})) {
    foreach my $checkparam(@$checkparams) {
      my $l_checkparam = $checkparam;
      $l_checkparam =~ s/(.)/\L$1/;
      $paramcheck .= "    if( this.$l_checkparam == null )\n      throw new SdkException(\"$checkparam property is not set.\");\n";
    }
  }
  $paraminit = "\n$paramcheck\n$paraminit" if ($paramcheck ne "");

  my $reqinit = "    req = new $calltype();";
  if (my $u_overridevar = $requestoverride->{$callname}) {
    my $overridevar = $u_overridevar;
    $overridevar =~ s/(.)/\L$1/;
    $paraminit =~ s/^/  /g;
    $paraminit =~ s/\n/\n  /g;
    $paraminit = "    if (this.$overridevar != null)\n    {\n      req = this.$overridevar;\n    } else {\n  $reqinit\n$paraminit\n    }\n";
    # print STDERR $paraminit;
    my $getout = getreturnlogic($gettemplate, $callname, $u_overridevar, $overridevar, $calltype);
    my $setout = getreturnlogic($settemplate, $callname, $u_overridevar, $overridevar, $calltype);
    $sortoutput->{"99999.override"} = $getout . "\n" . $setout;
    $privatemember .= "  private $calltype $overridevar=null;\n";
  } else {
    $paraminit = "$reqinit\n$paraminit";
  }

  my $responserec = $types->{$responsetype};
  my $returncode = "";
  my $returntype = "void"; # returnindex -1 sets default - void
  my $responsechildren = $responserec->{children};
  my $returnindex = $returnmap->{$k} || 0;
  my $returnname = undef;
  my $lastreturncode;

  foreach my $i (0..$#$responsechildren) {
    my $element = $responsechildren->[$i];
    my $paramname = $element->{name} || 'noname';
    $paramname =~ s/(.)/\U$1/;
    my $paramtype = $element->{type} || 'notype';
    my $paramobjname = $element->{paramobjname};

    if (defined(my $rename = $returnalias->{"$callname.$paramname"})) {

#        $origparamname = $paramname unless ($paramname =~ /SubCategor/);
	$origparamname = $paramname if (!defined($origparamname));
        $paramname = $rename;
      }


    my $u_origparamname = $paramname;
    my $origparamname = $u_origparamname;
    $origparamname =~ s/(.)/\L$1/;

    $paramname = "returned$paramname";
    if (defined(my $rename = $returnalias->{"$callname.$paramname"})) {
        $paramname = $rename;
    }
    my $u_paramname = $paramname;
    $u_paramname =~ s/(.)/\U$1/;
    
    my $castcode = "";
    my $defvalue = "null";
    my $paramlangtype = getlanguagetype($paramtype, $element->{max}, \%imports);
    if (defined(my $ref = $wrapperType->{"$callname.$u_paramname"})) {
      my ($wrappertype, $castfn);
      if (ref($ref) eq "ARRAY") {
	($wrappertype, $castfn) = @$ref;
	$castfn .= "()" unless ($castfn eq "");
	$defvalue = "0" if ($wrappertype eq "int" || $wrappertype eq "long");
	$defvalue = "false" if ($wrappertype eq "boolean");
      } else {
	$wrappertype = $ref;
	$castfn = "${wrappertype}Value()";
	$defvalue = "0" if ($wrappertype eq "int" || $wrappertype eq "long");
	$defvalue = "false" if ($wrappertype eq "boolean");
      }
      $paramlangtype = $wrappertype;
      $castcode = $castfn;
    }

    if ($i == $returnindex) {
      $returntype = $paramlangtype;
      $lastreturncode = "    return this.get$u_paramname();";
    }

    my $paramdoc =  $doc->{$paramobjname};
    $paramdoc =~ s/^\s*//m;
    $paramdoc =~ s/^\s+/ * /gm;
    my $paramdocout = "<br> <B>Output property:</B> <code>$u_paramname</code> - $paramdoc";
    my $returnout = getreturnlogic($returntemplate, $callname, $u_paramname, $paramname, $paramlangtype);
    $paramsdoc .= $paramdocout;

    $allfunctions .= "$returnout";

    $privatemember .= "  private $paramlangtype $paramname=$defvalue;\n";

    my $responsemember;
    if ($paramlangtype eq "boolean" || $paramlangtype eq "Boolean") {
    	$responsemember = "is$u_origparamname()";
    } else {
    	$responsemember = "get$u_origparamname()";
    }
    if ($castcode eq "") {
      $responsemember = "isHasMoreItems()" if ("$callname.$u_origparamname" =~ /(GetSearchResults|GetCategoryListings)\.HasMoreItems/);
      $responsemember = "isHasMoreEntries()" if ("$callname.$u_origparamname" =~ /GetSearchResultsExpress\.HasMoreEntries/);
      $returncode .= "    this.$paramname = resp.$responsemember;\n";
    } else {
      #my $responsemember = "get$u_origparamname()";
      #if ("$callname.$u_origparamname" eq "GetAccount.HasMoreEntries") {
      #	$responsemember = "isHasMoreEntries()";
      #	
      #}
      $returncode .= "    this.$paramname = (resp.$responsemember == null? $defvalue: resp.$responsemember.$castcode);\n";
    }

    my $record = $oldfunctions{"$callname.get$u_paramname."};
    if (defined($record)) {
      if ($record->{returntype} eq $paramlangtype) {
	#print "Match: $callname.get$u_paramname.$paramlangtype\n";
      } else {
	print "  2. Match but wrong type $record->{returntype} / $paramlangtype: $callname.get$u_paramname\n";
	#print "Z		       \"$callname.get$u_paramname\" => \"$record->{returntype}\", \"\"\n";
      }
      my $order = sprintf("%05d", $record->{order});
      $sortoutput->{$order} = $returnout;
      $record->{match} = 1;
    } else {
      $sortoutput->{"ZZZreturn.$u_paramname.$paramlangtype"} = $returnout;
      #print "    Extra: $callname.get$u_paramname.\n";
    }
  }

  if (defined(my $u_extra = $extrareturn->{$callname})) {
    my $l_extra = $u_extra;
    $l_extra =~ s/(.)/\L$1/;

    my $extraout = getreturnlogic($returntemplate, $callname, $u_extra, $l_extra, $callname . "ResponseType");
    $extraout =~ s/returned ${callname}.*/returned ${callname}ResponseType./;
    $extraout =~ s/this\.$l_extra/(${callname}ResponseType) this.getResponseObject()/;
    $allfunctions .= "$extraout";
    
    my $record = $oldfunctions{"$callname.get$u_extra."};
    if (defined($record)) {
      my $order = sprintf("%05d", $record->{order});
      $sortoutput->{$order} = $extraout;
      $record->{match} = 1;
    } else {
      $sortoutput->{"ZZZZextra.$u_extra"} = $extraout;
    }
  }

  if ((my $finalexeclogic = slurp("javamap/$callname.finalexec.txt")) ne "") {
    $returncode .= $finalexeclogic;
    #print STDERR $returncode;
  }

  if (ref($returnindex) eq "ARRAY") {
    ($returntype, $specialreturncode) = @$returnindex;
    $returncode .= "    return $specialreturncode;\n";
  } elsif (defined($lastreturncode)) {
    $returncode .= $lastreturncode;
  } else {
    if ($returnindex == -2) {
      $returntype = "${callname}ResponseType";
      $returncode .= "    return resp;";
    }
  }

  my $callout = $template;

  my $constrinit=slurp("javamap/$callname.constrinit.txt");
  my $import = "";
  foreach my $i (sort keys %imports) {
    $import .= "import $i;\n";
  }
  my $extraimports = slurp("javamap/$callname.imports.txt");
  $import = $extraimports . $import;

  my $private = slurp("javamap/$callname.private.txt");
  $privatemember .= "\n$private" if ($private ne "");

  my $privatefns = slurp("javamap/$callname.privatefns.txt");
  $allfunctions .= $privatefns;

  my $executefn = slurp("javamap/$callname.execfn.txt");
  if ($executefn eq "") {
    my $executetemplate = slurp("execute.template.txt");
    $executefn = $executetemplate;
    $executefn =~ s/\%Calldoc\%/$calldoc/g;
    $executefn =~ s/\%Returntype\%/$returntype/g;
    $executefn =~ s/\%callname\%/$l_callname/g;
    $executefn =~ s/\%Callname\%/$callname/g;
    $executefn =~ s/\%Returncode\%/$returncode/g;
    $executefn =~ s/\%Paraminit\%/$paraminit/g;
  }
  $allfunctions = $executefn . $allfunctions;
  my $returnrec = $oldfunctions{"$callname.$l_callname."};
  if (defined($returnrec)) {
    if ($returnrec->{returntype} ne $returntype && $callname ne "GeteBayOfficialTime") {
      print "  3. Match but wrong type $returnrec->{returntype} / $returntype: $callname.$l_callname.\n";
      #print "Z		    $callname => -2,\n" if ($returnrec->{returntype} =~ /ResponseType$/);
    }
    $returnrec->{match} = 1;
    my $order = sprintf("%05d", $returnrec->{order});
    $sortoutput->{$order} = $executefn;
  } else {
    $sortoutput->{".execute"} = $executefn;
  }
  
  my $savedfunctions = {};
  analyzeFunctions($callname, $privatefns, $savedfunctions);
  for ($c = 2; ($privatefns = slurp("javamap/$callname.privatefns$c.txt")) ne ""; $c++) {
    # print STDERR $privatefns;
    analyzeFunctions($callname, $privatefns, $savedfunctions, 1);
  }

  foreach my $k (keys %$savedfunctions) {
    my $savedrec = $savedfunctions->{$k};
    my $oldrec = $oldfunctions{$k};
    if (defined($oldrec)) {
      #if ($savedrec->{returntype} ne $oldrec->{returntype}) {
#	print "  Should not happen!! match but wrong type on '$k' .\n";
#      }
      $oldrec->{match} = 1;
      my $order = sprintf("%05d", $oldrec->{order});
      $sortoutput->{$order} = $savedrec->{body} . "\n";
    } else {
      $sortoutput->{"ZZZZZprivate.$k"} = $savedrec->{body} . "\n";
    }
  }

  $allfunctions = "";
  foreach my $k (sort keys %$sortoutput) {
    #print "QQQ $callname: $k\n";
    #print "$k: " . $sortoutput->{$k};
    $allfunctions .= $sortoutput->{$k};
  }

  $callout =~ s/\%Import\%/$import/g;
  $callout =~ s/\%Paramdoc\%/$paramsdoc/g;
  $callout =~ s/\%Privatemember\%/\n$privatemember/g;
  $callout =~ s/\%Callname\%/$callname/g;
  $callout =~ s/\%Constrinit\%/\n$constrinit/g; # currently unused
  $callout =~ s/\%Allfunctions\%/$allfunctions/mg;
  print OUTF $callout;
  close OUTF;

  foreach my $reckey (sort keys %oldfunctions) {
    next unless ($reckey =~ /^$callname\./);
    my $record = $oldfunctions{$reckey};
    next if ($record->{match});
    print "No match: $reckey\n";
  }
  #print "================\n";
}



sub slurp {
  my $filename = shift;
  my $value = "";
  if (open(INFILE, $filename)) {
    my $holdTerminator = $/;
    undef $/;
    $value = <INFILE>;
    $/ = $holdTerminator;
    close INFILE;
  }
  return $value;
}

#####

sub getreturnlogic {
  my ($returntemplate, $callname, $u_paramname, $paramname, $paramtype, $doc) = @_;

  my $output = $returntemplate;
  $doc ||= "";
  $output =~ s/\%Returndoc\%/$doc/g;
  $output =~ s/\%Callname\%/$callname/g;
  $output =~ s/\%Paramname\%/$u_paramname/g;
  $output =~ s/\%paramname\%/$paramname/g;
  $output =~ s/\%Paramtype\%/$paramtype/g;

  return $output;
}

# One-time usage to pull the old signatures from the old non-generated wrappers.
sub scanOldWrappers {
  my ($callname) = @_;
#return unless ($callname eq "AddItem");
  if (open (INF, "apiCalls/src/com/ebay/sdk/call/${callname}Call.java")) {
    my $holdTerminator = $/;
    undef $/;
    my $comparetxt = <INF>;
    $/ = $holdTerminator;

    analyzeFunctions($callname, $comparetxt, \%oldfunctions);
    #foreach my $k (sort keys %oldfunctions) {print "key=$k; return=$oldfunctions{$k}->{returntype}\n";}
  }
}

sub analyzeFunctions {
  my ($callname, $comparetxt, $outfunctions, $single) = @_;
  my @compatfunc;
  if ($single) {
    # designed for the "privatefns2/3/etc." - order is not a valid value in this case.  Only one function should 
    # be present.
    @compatfunc = $comparetxt =~ m/(^\s*public (static\s*|)[^\s]*\s*[a-zA-Z0-9_]*\s*\(.*\)\s*(throws[^{]*|)(.|\n)*)/gm;
    pop @compatfunc;
  } else {
    @compatfunc = $comparetxt =~ m/(^\s*public (static\s*|)[^\s]*\s*[a-zA-Z0-9_]*\s*\(.*\)\s*(throws[^{]*|){[^}]*})/gm;
  }

    my $order = 1;
    foreach my $i (0 .. $#compatfunc) {
	# All the parenthesized groupings are pulled, but the two inner groupings at (static...) and (throws...)
        # are not needed, so we look only at the initial grouping and every third one after that.
	next unless ($i % 3 == 0);
	my $compatfunc = $compatfunc[$i];

	$compatfunc =~ m/(^\s*public (static\s*|)([^\s]*)\s*([a-zA-Z0-9_]*)\s*\((.*)\))/;
	my $whole = $1;
        my $oldstatic = $2;
	my $oldreturntype = $3;
	my $oldfuncname = $4;
	my $oldfuncparms = $5;
	if ($oldfuncname eq "") {
	  $oldfuncname=$oldreturntype;
	  $oldreturntype = "";
	}
	$oldreturntype =~ s/java\.(lang|util)\.//;
	$oldreturntype =~ s/com\.ebay\.soap\.eBLBaseComponents\.//;
	$oldfuncparms =~ s/\s.*//;
	$oldfuncparms =~ s/java\.(lang|util)\.//;
	$oldfuncparms =~ s/com\.ebay\.soap\.eBLBaseComponents\.//;
	my $locn = index($comparetxt, $whole);
	my $comparetrunc = substr($comparetxt, 0, $locn);
	$comparetrunc =~ m/(\/\*[^\n]*\n(\s*\*[^\n]*\n)*\s*\*\/\s*$)/;
	my $comment = $1;
	if(!defined($comment)) {
		$comment = "";
	}
	# print STDERR "$callname: $order: 1 $oldstatic 2 $oldreturntype 3 $oldfuncname 4 $oldfuncparms 5 $compatfunc\n" if ($callname eq "AddItem");
	# store a record by class name and function name and parameter, giving return type
	my $key = "$callname.$oldfuncname.$oldfuncparms";
	#print $key . "\n";
	$outfunctions->{$key} = {returntype => $oldreturntype, body => ($comment . $compatfunc), order => $order};
	$order++;
	$outfunctions->{$key}->{match} = 1 if ($oldfuncname eq "${callname}Call" && $oldfuncparms =~ /ApiContext|/);
    }
}

sub getreturnfn {
  my ($k, $callname) = @_;
  my $wholereturn = "";
  if (open (INF, "D:/cc/rmurphy_mig_sdk/APISDK/DOTNET.SOAP/Source/eBay.Service.SDK/Call0/${k}Call.cs")) {
    my $holdTerminator = $/;
    undef $/;
    my $comparetxt = <INF>;
    $/ = $holdTerminator;
    my @returnfn = $comparetxt =~ m/[\t ]*public.*\s*{\s*.*return ApiResponse\..*\s*}/gm;
    if (@returnfn) {
      foreach my $return (@returnfn) {
	$return =~ m/public [^ ]* ([^ \n]*)/g;
	my $returnname2 = $1;
	next if ($callname eq "GetCategories" && $returnname2 eq "MinimumReservePrice");
	next if ($callname eq "GetCategories" && $returnname2 eq "ReservePriceInclusive");
	next if ($callname eq "GeteBayOfficialTime" && $returnname2 eq "EBayTime");
	my $paramobjname = $callname . "ResponseType." . $returnname2;
	my $returncomment = $doc->{$paramobjname};
	$returncomment =~ s/^\s*/\t\t\/\/\/ /gm if ($returncomment);
	$wholereturn .= $returncomment . "\n" . $return . "\n";
      }
    }
  }
  return $wholereturn;
}

#####

sub getlanguagetype {
  my ($schematype, $max, $imports) = @_;
  $schematype =~ s/^ns://;
  my $langtype = $schematype;
  if (defined($paramlangmap->{$schematype})) {
    $imports->{$paramlangmap->{$schematype}} = 1;
    $langtype = $paramlangmap->{$schematype};
    $langtype =~ s/java\.[^.]*\.//;
  }
  $langtype .= "[]" if (defined($max) && $max ne "" && $max ne "1");
  #$langtype = "java.util.List<$langtype>" if (defined($max) && $max ne "" && $max ne "1");


  return $langtype;
}
