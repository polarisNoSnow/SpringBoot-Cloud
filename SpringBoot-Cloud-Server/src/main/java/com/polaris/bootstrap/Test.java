package com.polaris.bootstrap;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 北辰不落雪 
 * @date 2017年12月4日 下午3:04:49 
 * @Description
 */
public class Test {
	public static void main(String[] args) {
		String sign = "B1C58A1505518BD94AE598D857FB52F9";
		String app_secret_31 = "7de470569d85642684e53800ac132b99ca8c1edd";
		String res = "{\"Join\":{\"Language\":0,\"RelativeMobilePhones\":[\"18666662175\"],\"ContactMobilePhone\":\"18666662175\",\"Gift\":{\"GiftStatus\":0,\"GiftToMobile\":null,\"GiftToRealName\":null},\"uuid\":\"6c934da5-c3d9-42c3-9728-be0c983fbb4c\",\"Retroactive\":{\"RetroactiveMoney\":0.0,\"RequiredRetroactive\":false,\"IsRetroactiveSuccess\":false,\"RetroactiveOrderID\":null,\"RetroactiveTime\":null},\"RetroactiveMoney\":0.0,\"EventDateFrom\":\"2017-11-30T09:00:00+08:00\",\"EventDateTo\":\"2017-12-30T21:00:00+08:00\",\"_Retroactive\":{\"RetroactiveMoney\":0.0,\"RequiredRetroactive\":false,\"IsRetroactiveSuccess\":false,\"RetroactiveOrderID\":null,\"RetroactiveTime\":null},\"PayType\":0,\"OrderPayType\":-1,\"JoinId\":1091093189,\"IsAssigned\":true,\"CountryEx\":null,\"CityEx\":null,\"TicketPrice\":0.0,\"TicketTitle\":\"嘉宾\",\"JoinCateName\":\"15周年特约报名\",\"ScheduleIds\":null,\"ChannelID\":1087347313,\"ChannelName\":null,\"ProvinceEx\":null,\"ScrmCompanyId\":1083094606,\"MemberNumber\":null,\"WeiXinOpenId\":null,\"WeiXinAppId\":null,\"EventTitle\":\"银盛金融集团15周年庆典\",\"IsPrePare\":false,\"Address\":null,\"EventId\":1087347273,\"UserId\":0,\"JoinCateId\":1087347314,\"TicketId\":1087347315,\"RealName\":\"吴倩\",\"EventUserJoinImage\":\"\",\"AllowExchangeNameCard\":false,\"Email\":null,\"ConfirmTime\":\"2017/12/4 15:03:35\",\"CardImagePath\":null,\"Company\":\"\",\"PosStatusEx\":null,\"Mobile\":\"15111032762\",\"PNOpenId\":null,\"WeiXin\":null,\"IsSignIn\":false,\"SignInTime\":null,\"SignInCode\":\"21093189\",\"IsPaid\":true,\"PaidString\":\"已支付\",\"PayTime\":\"2017-12-04T15:03:35.375+08:00\",\"AddIP\":null,\"UpdateIP\":null,\"FromSite\":0,\"IsImported\":false,\"UserGroup\":null,\"IsSubstitued\":false,\"ExtraFields\":{},\"ExtraFieldsForES\":{},\"Remarks\":null,\"AddTime\":\"2017-12-04T15:03:34.891+08:00\",\"TotalAwardMoney\":0.0,\"LastAwardTime\":null,\"AwardLotteryIds\":null,\"ScanSpotStatisticList\":null,\"JoinContactId\":1091093184,\"OrderIdList\":[1091093185],\"ExistOrder\":true,\"TicketOrderID\":1091093185,\"RelativeSpotIds\":[1089948950],\"TrackingCode\":null,\"RecordVersion\":0,\"DiscountCode\":[],\"SiteDiscountCode\":null,\"Status\":1,\"SendCodeTimes\":0,\"AllowSendCodeTimes\":0,\"AllowSendSMSTimes\":0,\"SendSMSTimes\":0,\"UseReplySMS\":false,\"IdCardNo\":null,\"IsEmailOpened\":false,\"IdCardType\":null,\"PrintCount\":0,\"DepartmentEx\":null,\"PrintBG\":null,\"LastPrintTime\":null,\"FullPY\":\"WUQIAN,WQ 吴倩\",\"SignInFromName\":null,\"TicketInfoList\":[{\"TicketId\":1087347315,\"TicketName\":\"嘉宾\",\"TicketPrice\":0.0,\"CateId\":1087347314,\"CateName\":\"15周年特约报名\",\"SpotId\":0,\"SignInTime\":null,\"IsSignIn\":false,\"EventId\":1087347273,\"VerifyCode\":\"18666662175\"}],\"RoleIds\":null,\"RoleName\":null,\"LeaveReason\":null,\"RejectReason\":null,\"ApprovalLeaveStatue\":0,\"ApprovalLeaveStatuestr\":\"\",\"ApprovalTime\":null,\"AlterJoinFieldStatue\":0,\"AlterJoinFieldContent\":null,\"JoinNumber\":8,\"OperatingUserName\":\"管理员\",\"OperatingUserType\":0,\"GlobalRoaming\":null,\"BelongsUserId\":0,\"NickName\":null,\"IsSignInProductPackageDeduction\":false,\"MemberType\":null,\"MemberTypeId\":null,\"MemberGroup\":null,\"MemberGroupIds\":null,\"ContactGroup\":null,\"ContactGroupIds\":null,\"CreateTime\":\"2017-12-04T15:03:34.876+08:00\",\"UpdateTime\":\"2017-12-04T15:03:35.375+08:00\",\"NeedChangeFieldNames\":null,\"DbBackupHistoryLogId\":0,\"NotNeedRecordDbOperatingHistoryLog\":false,\"_id\":\"5a24f346634198d26052627e\",\"__v\":1,\"IsDeleted\":false},\"Log\":{\"LogId\":1092714047,\"UUId\":\"6c934da5-c3d9-42c3-9728-be0c983fbb4c\",\"LogGUID\":\"72105ff3-e505-430e-a8e6-82c491121042\",\"EventId\":1087347273,\"SpotId\":1092574623,\"DeviceId\":1092571995,\"DeviceCode\":\"E5F6B2CF-6220-491A-95FF-F7616E3E9ABC\",\"JoinId\":1091093189,\"RealName\":\"吴倩\",\"SignInCode\":\"21093189\",\"ScanCounting\":0,\"SendFiles\":false,\"ShouldScan\":true,\"AddTime\":\"2017-12-06T19:36:00.572267+08:00\",\"Remark\":\"\",\"SpotTitle\":\"默认签到点\",\"IsRepeat\":false,\"Direction\":0,\"DeviceName\":\"未设置名称\",\"SignFromType\":1,\"DeviceTypeName\":\"iOS\",\"CreateTime\":\"2017-12-06T19:36:00.572267+08:00\",\"UpdateTime\":\"2017-12-06T19:36:00.572267+08:00\",\"NeedChangeFieldNames\":null,\"DbBackupHistoryLogId\":0,\"NotNeedRecordDbOperatingHistoryLog\":false,\"_id\":\"5a27d62063419856a004ec7e\",\"__v\":0,\"IsDeleted\":false}}";	

		Map map = (Map) JSONObject.parse(res);
		Map resMAP = (Map) JSONObject.parse(res);
		String message = JSONObject.toJSONString(resMAP)+app_secret_31;
		Map<String, Object> x = (Map<String, Object>) resMAP.get("Join");
		System.out.println(x.get("Mobile"));
		String mySign = "";
		try {
			mySign = new String(Hex.encodeHex(MessageDigest.getInstance("MD5").digest((res+app_secret_31).getBytes()), true));
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		System.out.println(mySign.toUpperCase());
	}
}
