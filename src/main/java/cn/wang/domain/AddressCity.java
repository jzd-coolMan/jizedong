package cn.wang.domain;

public class AddressCity {
    private Integer id;

    private String code;

    private String name;

    private String provincecode;
    //省
    private AddressProvince addressProvince;
    
    public AddressProvince getAddressProvince() {
		return addressProvince;
	}

	public void setAddressProvince(AddressProvince addressProvince) {
		this.addressProvince = addressProvince;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode == null ? null : provincecode.trim();
    }
}