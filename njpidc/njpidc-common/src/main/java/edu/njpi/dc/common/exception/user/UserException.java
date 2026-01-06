package edu.njpi.dc.common.exception.user;

import edu.njpi.dc.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author njpidc
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
