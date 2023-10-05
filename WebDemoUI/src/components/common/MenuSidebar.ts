import MSidebarDetail from "./MSidebarDetail"
export default class MenuSidebar {
	logoURL: string;
	mSidebarDetail: Array<MSidebarDetail>;
	public constructor(logoURL: string, mSidebarDetail: Array<MSidebarDetail>) {
		this.logoURL = logoURL;
		this.mSidebarDetail = mSidebarDetail;
	}
}